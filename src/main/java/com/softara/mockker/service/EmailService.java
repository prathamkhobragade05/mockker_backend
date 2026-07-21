package com.softara.mockker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.softara.mockker.model.OtpModel;
import com.softara.mockker.repository.OtpRepository;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private OtpService otpService;
    
	@Autowired
	OtpRepository otpRepo;

    public ResponseEntity<?> sendMail(String receiver) {
    	
    	OtpModel otpModel=otpService.createOTP(receiver);

    	if(otpModel==null) return ResponseEntity.status(500).body("Internal Server Error");
    	
        SimpleMailMessage message = new SimpleMailMessage();

//        message.setFrom(fromEmail);
        message.setTo(receiver);
        message.setSubject("Mockker - Email Verification");
        message.setText(otpModel.getOtp()+" is your otp for Email Verification");

        try {
            mailSender.send(message);
        	otpRepo.save(otpModel);
            
            return ResponseEntity.ok("otp sent");
         } 
        catch (Exception e) { 
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body("Internal Server Error");
        } 
    }
}