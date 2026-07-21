package com.softara.mockker.model;

import jakarta.persistence.*; 
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class UserModel {
	
    @Id
    @Column(name="UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="Email", nullable = false, unique = true)
    private String email;
    
    @Column(name="Password", nullable = false)
    private String password;
    
    @Column(name="FirstName", nullable = false)
    private String firstName;
    
    @Column(name="LastName", nullable = false)
    private String lastName;
    
    
    @Column(name="MobileNo", nullable = false)
    private String mobile;
    
    @Column(name="Gender", nullable = false)
    private String gender;
    
    @Column(name="DateOfBirth", nullable = false)
    private String dob;
    
    @Column(name="EmailVerified")
    private Boolean emailVerified;
    
    @Column(name="CreatedAt", nullable = false)
    private String createdAt;
    
    @Column(name="UpdatedAt", nullable = false)
    private String updatedAt;
    
    public UserModel(Long userId, String email, String password, String firstName, String lastName, String mobile, String gender, String dob, Boolean emailVerified, String createdAt, String updatedAt){
    	this.userId=userId;
		this.email=email;
		this.password=password;
    	this.firstName=firstName;
		this.lastName=lastName;
		this.mobile=mobile;
		this.gender=gender;
		this.dob=dob;
		this.emailVerified=emailVerified;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
    };
    public UserModel() {}
    
    
	public void setUserId(Long userId) {this.userId=userId;}
	public void setEmail(String email) {this.email=email;}
	public void setPassword(String password) {this.password=password;}
	public void setFirstName(String firstName) {this.firstName=firstName;}
	public void setLastName(String lastName) {this.lastName=lastName;}
	public void setMobile(String mobile) {this.mobile=mobile;}
	public void setGender(String gender) {this.gender=gender;}
	public void setDob(String dob) {this.dob=dob;}
	public void setEmailVerified(Boolean verified) {this.emailVerified=verified;}
	public void setCreatedAt(String createdAt) {this.createdAt=createdAt;}
	public void setUpdatedAt(String updatedAt) {this.updatedAt=updatedAt;}

	public Long getUserId() {return userId;}
	public String getEmail() {return email;}
	public String getPassword() {return password;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getMobile() {return mobile;}
	public String getGender() {return gender;}
	public String getDob() {return dob;}
	public Boolean getEmailVerified() {return emailVerified;}
	public String getCreatedAt() {return createdAt;}
	public String getUpdatedAt() {return updatedAt;}
	
}
