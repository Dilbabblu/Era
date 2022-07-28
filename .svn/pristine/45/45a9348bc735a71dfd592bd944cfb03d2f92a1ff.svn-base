package com.forsys.revmantra.exceptions;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.forsys.revmantra.pojo.MailSend;
import com.forsys.revmantra.utils.MailSender;
import com.forsys.revmantra.utils.RevmantraUtils;

@ControllerAdvice
public class AyaraRestControllerExceptionHandler {
	
	@ExceptionHandler(value=NullPointerException.class)
	public ResponseEntity<ApiError> handleNullPointerException(){
		
		ApiError ae = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				                   "Some Null values issue.Please try after sometime");
		return new ResponseEntity<>(ae,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=AyaraCustomException.class)
	public ResponseEntity<ApiError> handleNullPointerException(AyaraCustomException ace){
		ApiError ae = new ApiError(HttpStatus.BAD_REQUEST.value(),
								   ace.getMessage());
		return new ResponseEntity<>(ae,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> defaultErrorHandler(final HttpServletRequest request, final Principal principal, final Exception e) {
		 if(RevmantraUtils.getProperty("log.enable_error_mail").equalsIgnoreCase("error")) {
			 MailSend mailSendBean = new MailSend();
			 mailSendBean.setToAddress(RevmantraUtils.getProperty("log.touser"));
			 mailSendBean.setSubject(RevmantraUtils.getProperty("log.subject"));
			 mailSendBean.setMailBody("Error Occured in Ayara Product Instance" + "\n\n"+ e + " at Line number " +e.getStackTrace()[0].getLineNumber()+" in "+e.getStackTrace()[0].getMethodName()+ " Method, Class: "+e.getStackTrace()[0].getClassName());
			 MailSender.sendMail(mailSendBean, false);
		 }
	 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
	
}
