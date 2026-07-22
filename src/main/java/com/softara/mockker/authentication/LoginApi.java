package com.softara.mockker.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softara.mockker.model.*;
import com.softara.mockker.repository.*;
import com.softara.mockker.service.*;



@RestController
@RequestMapping("mockker/auth")
public class LoginApi {

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	

	@Autowired
	OtpService otpService;
	
	@Autowired
	UserRepository userRepo;
	
	
	@Autowired
	JwtService jwtService;

	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		UserModel user = userRepo.findByEmail(request.getEmail());
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("User not found!");
	    }
	    
	    
	    if (!userService.passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body("Incorrect password");
        }
	    
	    String token= jwtService.generateToken(user.getEmail());
	    
	    return ResponseEntity.ok(new LoginResponse(token));
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserModel request){
		UserModel savedUser=userService.registerUser(request);
	    adminService.addActivity("New User"+savedUser.getEmail());
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	@PostMapping("/register/send-otp/{email}")
	public ResponseEntity<?> sendOtpForRegister(@PathVariable("email") String email){
		//--------- Check if email already exists

		UserModel user = userRepo.findByEmail(email);
		if (user != null) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body("Email Already Connected with us\nPlease Log in to your account");
	    }
		
		return emailService.sendMail(email); 
	}
	
	@PostMapping("/verify-otp")
	public ResponseEntity<?> verifyOtp(@RequestBody OtpModel otpModel){
		return otpService.verifyOtp(otpModel.getEmail(), otpModel.getOtp());
	}
	
}
