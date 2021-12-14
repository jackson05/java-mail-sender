package com.jackson.java.mail.javamail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.jackson.java.mail.javamail.service.MailService;

@SpringBootApplication
public class JavaMailApplication {
	@Autowired
	private MailService mail;

	public static void main(String[] args) {
		SpringApplication.run(JavaMailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		mail.sendMail("exemple.to@gmail.com", "My subject","My message");
		
	}
}
