package com.forsys.revmantra.pojo;

import java.io.Serializable;

public class MailSend implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String toAddress;
	
	private String subject;
	
	private String mailBody;

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = "Hi,\n\n" + mailBody + "\n\nPlease do not reply to this email." + "\nRegards" + "\nAyara Team.";
	}

}
