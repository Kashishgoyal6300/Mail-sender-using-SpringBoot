package com.mail.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.mail.entity.CustomResponse;
import com.mail.mail.entity.EmailRequest;
import com.mail.mail.services.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	//send email
	
	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		emailService.sendEmailWithHtml(request.getTo(), request.getSubject(), request.getMessage());
		return ResponseEntity.ok(
				CustomResponse.builder().message("Email sent succesfully").httpStatus(HttpStatus.OK).success(true).build());
	}
	
	
}
