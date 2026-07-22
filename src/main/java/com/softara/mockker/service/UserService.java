package com.softara.mockker.service;

import java.sql.Timestamp; 
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.softara.mockker.model.*;
import com.softara.mockker.repository.*;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TestRepository testRepo;
	
	@Autowired
	QuestionRepository questionRepo;
	
	@Autowired
	TestResultRepository resultRepo;
	
	@Autowired
	AnnouncementRepository announcementRepo;
	
	@Autowired
	ActivitiesRepository activityRepo;
	
	public final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public UserModel registerUser(UserModel request) {
		String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
		
		request.setEmailVerified(true);
		
	    request.setCreatedAt(timeStamp);
	    request.setUpdatedAt(timeStamp);
	    //--------encode password
	    request.setPassword(passwordEncoder.encode(request.getPassword()));
	    
	    return userRepo.save(request);
	}
	
	public UserModel loadUserProfile(String email){
		return  userRepo.findByEmail(email);
	}
	
	public ResponseEntity<?> updateFieldValue(NewValue newValue) {
		UserModel user = userRepo.findById(newValue.getUserId()).orElseThrow(()->new RuntimeException("User Not Found"));
		
		switch (newValue.getField()) {
			case "First Name":
				user.setFirstName(newValue.getValue());
				break;
			case "Last Name":
				user.setLastName(newValue.getValue());
				break;
			case "Email":
				try {
					user.setEmail(newValue.getValue());
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			case "Mobile Number":
				user.setMobile(newValue.getValue());
				break;
			case "Date of Birth":
				user.setDob(newValue.getValue());
				break;
			case "Gender":
				user.setGender(newValue.getValue());
				break;
			default:
				return ResponseEntity.badRequest().body("Invalid filed");
			
		}
		userRepo.save(user);
		return ResponseEntity.ok("Updated Successfully");
		
	}
	
	public List<TestModel> getListTest() {
		return testRepo.findAll();
	}

	public Optional<TestModel> getTestById(Long testId) {
		return testRepo.findById(testId);
	}

	public List<QuestionModel> getQuestionsByTestId(Long testId) {
		return questionRepo.findByTestIdOrderByQuestionIdAsc(testId);
	}

	public List<AnnouncementModel> getAnnouncement() {
		return announcementRepo.findAll();
	}

	public TestResultModel addResult(TestResultModel result) {
		result.setTimeStamp(new Timestamp(System.currentTimeMillis()).toString());
		return resultRepo.save(result);
	}
	
	public List<TestResultModel> getResultsByUserId(Long userId) {
		return resultRepo.findByUserId(userId);
	}

}
