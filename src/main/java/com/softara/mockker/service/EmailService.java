package com.softara.mockker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.softara.mockker.model.OtpModel;
import com.softara.mockker.repository.OtpRepository;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private OtpService otpService;
    
	@Autowired
	OtpRepository otpRepo;
	
	@Value("${spring.mail.sender}")
	private String senderEmail;

    public ResponseEntity<?> sendMail(String receiver) {
    	
    	OtpModel otpModel=otpService.createOTP(receiver);

    	if(otpModel==null) return ResponseEntity.status(500).body("Internal Server Error");
    	
    	MimeMessage message = mailSender.createMimeMessage();

    	try {
    		String body="Dear User,\n\n "
    				+ "Use <b>"+otpModel.getOtp()+"</b> as OTP to proceed with Registration.\nOTP is valid for 10 mins"
    						+ "\n\nNote:This is an auto generated mail. Do not reply to this email"
    						+ "\n\n<b>Mockker - prevtech.in</b>";
    		
    	    MimeMessageHelper helper = new MimeMessageHelper(message, false);

    	    helper.setFrom("noreply@prevtech.in", "Mockker");
    	    helper.setTo(receiver);
    	    helper.setSubject("OTP for Email Verification");
    	    helper.setText(body);

    	    mailSender.send(message);
    	    otpRepo.save(otpModel);
    	    return ResponseEntity.ok("otp sent");

    	} 
    	catch (Exception e) {
    		return ResponseEntity.status(500).body("Internal Server Error");
    	}
    	
    }
}
