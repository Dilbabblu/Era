package com.forsys.revmantra.utils;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.forsys.revmantra.pojo.MailSend;

public class MailSender {
	
	private static final Logger logger = LogManager.getLogger(MailSender.class);

	private MailSender() {
		
	}
	
	public static void sendMail(MailSend mailSendBean, Boolean isHtml) {


		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		Properties props = new Properties();
		try {
			props.put("mail.smtp.host", RevmantraUtils.getProperty("mail.host"));
			props.put("mail.smtp.socketFactory.port",RevmantraUtils.getProperty("mail.smtp.socketFactory.port"));
			props.put("mail.smtp.socketFactory.class",RevmantraUtils.getProperty("mail.smtp.socketFactory.class"));
			props.put("smtp.auth", RevmantraUtils.getProperty( "mail.properties.mail.smtp.auth"));
			props.put("smtp.port", RevmantraUtils.getProperty("mail.port"));
			
			mailSender.setJavaMailProperties(props);
			mailSender.setUsername(RevmantraUtils.getProperty("mail.username"));
			mailSender.setPassword(RevmantraUtils.getProperty("mail.password"));
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
		    helper.setTo(mailSendBean.getToAddress());
			helper.setSubject(mailSendBean.getSubject());
			helper.setText(mailSendBean.getMailBody(), isHtml); 
			mailSender.send(message);
			logger.info("Mail Sent Successfully");
		}catch(Exception e) {
			logger.error("Exception occured while sending email {}", e.getMessage());
		}
	}

}
