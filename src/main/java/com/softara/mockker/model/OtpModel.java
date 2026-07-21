package com.softara.mockker.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "OTP")
public class OtpModel {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="emailId")
	private String email;
	
	@Column(name="otp")
	private String otp;
	
	@Column(name="expiryTime")
	private LocalDateTime expiryTime;
	
	
	public OtpModel(Long id, String email, String otp, LocalDateTime expiryTime) {
		this.id=id;
		this.email=email;
		this.otp=otp;
		this.expiryTime=expiryTime;
	}
	
	
	public OtpModel(){}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}
}
