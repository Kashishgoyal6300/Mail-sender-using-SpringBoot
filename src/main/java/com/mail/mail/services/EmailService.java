package com.mail.mail.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {
	
	//sendEmail to single perosn
	void sendEmail(String to,String subject,String message) ;
	//
		//send email o multiple person
	void sendEmail(String []to,String subject,String message);
	
	void sendEmailWithHtml(String to,String object,String htmlContent);
	
	//void send email with file
	
	void sendEmailWithFile(String to,String subject,String message,File file);

	
	
}
