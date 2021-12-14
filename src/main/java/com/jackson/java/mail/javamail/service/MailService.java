package com.jackson.java.mail.javamail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public String sendMail(String mailTo,String subject,String body ) {
		try {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom("exemple.from@gmail.com");
		mailMessage.setTo(mailTo);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		mailSender.send(mailMessage);
		System.out.println("mail sent");
		return "message sent";
		}catch (Exception e) {
			System.out.println("mail not sent");
			return e.getMessage();
		}
	}
}
