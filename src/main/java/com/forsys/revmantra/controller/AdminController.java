package com.forsys.revmantra.controller;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.pojo.MailSend;
import com.forsys.revmantra.repositories.RmanUsersRepository;
import com.forsys.revmantra.utils.EncryptAndDecryptUtil;
import com.forsys.revmantra.utils.MailSender;
import com.forsys.revmantra.utils.RevmantraUtils;

@Controller
public class AdminController {
	private static final Logger logger = LogManager.getLogger(AdminController.class);
	
	@Autowired
	private RmanUsersRepository rmanUsersRepo;

    @GetMapping(value = "/forgotPassword")
	@ResponseBody
	public String forgotPassword(@RequestParam(value = "userId") String userId) {
    	String status = null;
		try {
			RmanUsers ayaraUser = rmanUsersRepo.findByUserNameIgnoreCase(userId);

			if (ayaraUser != null && ayaraUser.getEnabledFlag().equalsIgnoreCase("Y")) {
				Long currentTime = System.currentTimeMillis();
				Long expirytime = Long.parseLong(RevmantraUtils.getProperty("expirytime"));
				Long timestamp = currentTime + expirytime;
				String token = ayaraUser.getUserName() + "/" + timestamp;
				String host = RevmantraUtils.getProperty("server.host");
				if (RevmantraUtils.getProperty("server.ssl.enabled").equals("true") && host.contains("http://")) {
					host = host.replace("http", "https");
				}
				if (ayaraUser.getAttribute4() == null) {
					ayaraUser.setAttribute4(UUID.randomUUID().toString());
				}
				String encryptedtoken = EncryptAndDecryptUtil.encrypt(ayaraUser.getAttribute4(), token);
				ayaraUser.setAttribute5(encryptedtoken);
				rmanUsersRepo.save(ayaraUser);
				String uri = URLEncoder.encode(encryptedtoken, "UTF-8");
				String url = "";
				if (Integer.parseInt(RevmantraUtils.getProperty("server.port")) == 443) {
					url = host + "/resetPassword?resetId=" + uri;
				} else {
					url = host + RevmantraUtils.getProperty("server.port") + "/resetPassword?resetId=" + uri;
				}
				URL domain = new URL(url);
				MailSend mailSendBean = new MailSend();
				mailSendBean.setToAddress(ayaraUser.getEmailAddress());
				mailSendBean.setSubject("Password Reset Link");
				mailSendBean.setMailBody("Please click on the link to reset your password" + "\n\n" + domain);
				MailSender.sendMail(mailSendBean, false);
				status = "{\"statusCode\":0,\"Msg\":\"Password Reset link has been sent to mail\" }";
			} else if (ayaraUser != null && ayaraUser.getEnabledFlag().equalsIgnoreCase("N")) {
				//AYAR-1794 Added by Madhu Sri on 23-Feb'22
				status = "{\"statusCode\":0,\"Msg\":\"The password reset link will be sent to the registered email if it exists or active. \" }";
			} else if (ayaraUser == null) {
				//AYAR-1794 Added by Madhu Sri on 23-Feb'22
				status = "{\"statusCode\":0,\"Msg\":\"The password reset link will be sent to the registered email if it exists or active. \" }";
			}
		} catch (Exception e) {
			logger.error("Error Occured while sending password reset link {}", e.getMessage());
			return "{\"statusCode\":0,\"Msg\":" + e.getMessage() + "}";
		}
		return status;
	}
    
    
	@GetMapping(value = "/resetPassword")
	public String resetPassword(@RequestParam(value = "resetId") String token) {

		List<RmanUsers> users = rmanUsersRepo.findAll(RevmantraUtils.fetchSpecification(RmanUsers.class,"attribute5:"+token));
		if (!users.isEmpty()) {
			String tokenExists = users.get(0).getAttribute5();
			if (tokenExists != null) {
				try {
					String[] decryptedToken = EncryptAndDecryptUtil.decrypt(users.get(0).getAttribute4(), token);
					Long expiryDate = Long.parseLong(decryptedToken[1]);
					Long currentTime = System.currentTimeMillis();
					if (currentTime < expiryDate) {
						String tokenId = URLEncoder.encode(tokenExists, "UTF-8");
						return "redirect:/auth/forgotPassword.html?tokenId=" + tokenId;

					} else {
						return "redirect:/auth/forgotPassword.html?statusMsg=Password reset link Expired";
					}
				} catch (Exception e) {
					logger.error("Error Occurred while resetting Password {}", e.getMessage());
					return e.getMessage();
				}
			}
		}
		return "redirect:/auth/forgotPassword.html?statusMsg=Password reset link has been expired/Already Used";
	}
	
	
	@GetMapping(value = "/saveResetPassword")
	@ResponseBody
	public String saveResetPassword(@RequestParam(value="token") String token, @RequestParam(value="userId") String userId,
			@RequestParam(value="newPwd") String newPwd)
			throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException,
			UnsupportedEncodingException {

		try {
			List<RmanUsers> listUsers = rmanUsersRepo.findAll(RevmantraUtils.fetchSpecification(RmanUsers.class,"attribute5:"+token));
			if (!listUsers.isEmpty()) {
				String[] decryptedToken = EncryptAndDecryptUtil.decrypt(listUsers.get(0).getAttribute4(), token);
				String userIdFromToken = decryptedToken[0];
				if (userIdFromToken.equalsIgnoreCase(userId)) {
					RmanUsers users = rmanUsersRepo.findByUserNameIgnoreCase(userIdFromToken);
					return savePassword(users, token, newPwd);
				}
				return "{\"statusCode\":0,\"Msg\":\"User Name does not match\"}";
			}
		} catch (Exception e) {
			logger.error("Error Occured while saving the password {}", e.getMessage());
			return "{\"statusCode\":0,\"Msg\":" + e.getMessage() + "}";
		}
		return "{\"statusCode\":0,\"Msg\":\"Password reset link has been already used/invalid token\"}";
	}
	
	private String savePassword(RmanUsers users, String token, String newPwd) {
		if (users != null) {
			if (users.getAttribute5() != null) {
				if (users.getAttribute5().equals(token)) {
					String status = users.getEnabledFlag();
					if ("N".equalsIgnoreCase(status)) {
						return "{\"statusCode\":0,\"Msg\":\"User is Inactive. Please contact your administrator\" }";
					} else {
						String hashedPassword = EncryptAndDecryptUtil.encryptPassword(newPwd);
						users.setUserPassword(hashedPassword);
						users.setAttribute5(null);
						rmanUsersRepo.save(users);
						return "{\"statusCode\":1,\"Msg\":\"Password Changed Successfully\"}";
					}
				} else {
					return "{\"statusCode\":0,\"Msg\":\"Invalid Token for User\"}";
				}
			}
			return "{\"statusCode\":0,\"Msg\":\"Password reset link already used\"}";
		}
		return "{\"statusCode\":0,\"Msg\":\"User Not Found\"}";
		
	}
	
	
	
	
	
}
