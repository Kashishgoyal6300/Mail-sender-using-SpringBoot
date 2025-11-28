package com.mail.mail;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mail.mail.services.EmailService;

@SpringBootTest
public class EmailSenderTest {
	@Autowired
	private EmailService emailService;
	
	@Test
	void emailSendTest() {
		System.out.println("sending email");
		emailService.sendEmail("kashishgoyal0003@gmail.com", "This is testing email from springboot", "This email is send using springboot while creating email servie");
		
	}
	
	@Test
	void sendHtmlInEmail() {
	    String html = "<h1 style='color:red; border:1px solid red;'>Welcome to learn code from Kashish</h1>";

	    emailService.sendEmailWithHtml(
	            "kashishgoyal0003@gmail.com",
	            "Email from Spring Boot (HTML)",
	            html
	    );
	}
	@Test
	void sendEmailWithFile() {
		emailService.sendEmailWithFile("kashishgoyal0003@gmail.com", "email with file", "This email contains file",new File( "C:\\Users\\kashish.goyal\\Downloads\\mail\\mail\\src\\main\\resources\\static\\image\\download.png"));
	}

}
