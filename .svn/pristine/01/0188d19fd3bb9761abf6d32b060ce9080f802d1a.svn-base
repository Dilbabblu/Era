package com.forsys.revmantra.schedulers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.forsys.revmantra.pojo.MailSend;
import com.forsys.revmantra.utils.MailSender;
import com.forsys.revmantra.utils.RevmantraUtils;

@Component
public class EmailScheduler {

	private static final Logger logger = LogManager.getLogger(EmailScheduler.class);
	
	@Scheduled(cron = "0 50 23 * * *")
	   public void scheduleErrorMailSendJob() {
		
			if(RevmantraUtils.getProperty("log.enable_consolidated_error_mail").equalsIgnoreCase("true")) {
				Map<String, String> errorsMap = new HashMap<>();
				File file = new File("logs/application.log");
				try(Scanner scanner = new Scanner(file);) {
						if (file.exists()) {
							while (scanner.hasNextLine()) {
								String data = scanner.nextLine();
								if (data.contains("[ERROR]")) {
									String[] errorLine = data.split(" ");
									StringBuilder sb = new StringBuilder();
									for (int i = 6; i < errorLine.length; i++) {
										sb.append(errorLine[i]);
										sb.append(" ");
									}
									errorsMap.put(errorLine[0] + " " + errorLine[1] + " " + errorLine[4], sb.toString());
								}
							}
						}
				      
				      
				      	MailSend mailSendDto = new MailSend();
						mailSendDto.setToAddress(RevmantraUtils.getProperty("log.touser"));
						mailSendDto.setSubject(RevmantraUtils.getProperty("log.cons_email_sub"));
						
				      //if errors exists
				      if(!errorsMap.isEmpty()) {
					      StringBuilder htmlMail = new StringBuilder();
					      htmlMail.append("<div bgcolor=\"#FFFFFF\"><hr size=\"1\" noshade=\"\">Please find the below consolidated Errors List<br><br><table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" width=\"100%\"><tbody><tr><th>Time</th><th>Level</th><th>Logger</th><th>Message</th></tr>");
					      for (String key : errorsMap.keySet()) {
							String[] totalKeys = key.split(" ");
							String time = totalKeys[0]+" "+totalKeys[1];
							String loggerClass = totalKeys[2];
							String message = errorsMap.get(key);
							htmlMail.append("<tr><td>"+time+"</td><td><font color=\"#993300\"><strong>ERROR</strong></font></td><td>"+loggerClass+"</td><td>"+message+"</td></tr>");
					      }
					      htmlMail.append("</tbody></table></div>");
					      mailSendDto.setMailBody(htmlMail.toString());
					      MailSender.sendMail(mailSendDto , true);
						} else {
							// no errors
							mailSendDto.setMailBody(RevmantraUtils.getProperty("log.no_errors"));
							MailSender.sendMail(mailSendDto, false);
						}
				    } catch (Exception e) {
				      logger.error("Exception occured while sending consolidated errors Email", e);
				    }
			}
	   }
}
