package com.softara.mockker.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softara.mockker.model.OtpModel;
import com.softara.mockker.repository.OtpRepository;

@Service
public class OtpService {
	
	@Autowired
	OtpRepository otpRepo;
	
	public OtpModel createOTP(String email) {
		String newOtp=String.format("%06d", new Random().nextInt(1000000));
		
		OtpModel otpModel =new OtpModel();
		otpModel.setEmail(email);
		otpModel.setOtp(newOtp);
		otpModel.setExpiryTime(LocalDateTime.now().plusMinutes(5));
		
		return otpModel;
	}
	
	public ResponseEntity<?> verifyOtp(String email, String enteredOtp) {
		Optional<OtpModel> optional= otpRepo.findTopByEmailOrderByExpiryTimeDesc(email);
		
		if(optional.isEmpty()) {
			return ResponseEntity.status(500).body("Internal Server Error");
		}
		
		OtpModel otp=optional.get();
		
		if(LocalDateTime.now().isAfter(otp.getExpiryTime())) {
			return ResponseEntity.badRequest().body("OTP expired!");
		}
		
		if(otp.getOtp().equals(enteredOtp)) {
			otpRepo.delete(otp);
			return ResponseEntity.ok().body("OTP verified");
			
		}
		
		return ResponseEntity.badRequest().body("Incorrect OTP");
	}
}
