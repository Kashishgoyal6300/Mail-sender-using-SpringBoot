package com.mail.mail.services;

import java.io.File;
import java.io.InputStream;

import org.slf4j.Logger; 

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	private Logger logger=LoggerFactory.getLogger(EmailServiceImpl.class);
	

	@Override
	public void sendEmail(String to, String subject, String message) {
	SimpleMailMessage simpleMailMessage	=new SimpleMailMessage();
	simpleMailMessage.setTo(to);
	simpleMailMessage.setSubject(subject);
	simpleMailMessage.setText(message);
	simpleMailMessage.setFrom("kashishgoyal0090@gmail.com");
		mailSender.send(simpleMailMessage);
		logger.info("Email has been sent ");
	}

	@Override
	public void sendEmail(String[] to, String subject, String message) {
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("kashishgoyal0090@gmail.com");
		mailSender.send(simpleMailMessage);
		logger.info("Email has been sent ");
	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
		MimeMessage simpleMailMessage=mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper=new MimeMessageHelper(simpleMailMessage,true,"UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("kashishgoyal0090@gmail.com");
			helper.setText(htmlContent,true);
			mailSender.send(simpleMailMessage);
			logger.info("Email has been sent ");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, File file) {

	    MimeMessage mimeMessage = mailSender.createMimeMessage();

	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

	        helper.setFrom("kashishgoyal0090@gmail.com");
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(message);

	        FileSystemResource fileResource = new FileSystemResource(file);

	        // FIXED -> use fileResource and call getFilename() correctly
	        helper.addAttachment(fileResource.getFilename(), fileResource);

	        mailSender.send(mimeMessage);
	        logger.info("Email with file sent successfully!");
	        
	    } catch (MessagingException e) {
	        logger.error("Error sending email with attachment: ", e);
	    }
	}

}
