package com.softara.mockker.controller;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softara.mockker.model.*;
import com.softara.mockker.service.UserService;



@RestController
@RequestMapping("mockker/user") 
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<UserModel> loadUserProfile(Authentication authentication) {
	    String email = authentication.getName();
	    return ResponseEntity.ok(userService.loadUserProfile(email));
	}
	
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateFieldValue(@RequestBody NewValue newValue){
		return userService.updateFieldValue(newValue);
	}
	
	
	@GetMapping("/getTests")													//---------get list of tests
	public ResponseEntity<List<TestModel>> getListTest() {
		return ResponseEntity.ok(userService.getListTest());
	}
	
	@GetMapping("/getTest")													//---------get test by testId
	public ResponseEntity<?> getTestById(Long testId) {
		return ResponseEntity.ok(userService.getTestById(testId));
	}
	
	
	@GetMapping("/getQuestions/{testId}")									//---------get questions by test
	public ResponseEntity<List<QuestionModel>> getQuestionBankByTestId(@PathVariable("testId") Long testId) {
		List<QuestionModel> questionModel= userService.getQuestionsByTestId(testId);
		return ResponseEntity.ok(questionModel);
	}
	
	@GetMapping("/getResults/{userId}")													//---------get list of results
	public ResponseEntity<List<TestResultModel>> getResultsByUserId(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(userService.getResultsByUserId(userId));
	}
	
	@PostMapping("/addResult")													//----------add test result
	String addResult(@RequestBody TestResultModel result) {
		TestResultModel testResultModel= userService.addResult(result);
		return ("test result added id:"+testResultModel.getUserTestId().toString());
	}
	
	@GetMapping("/getAnnouncement")
	public List<AnnouncementModel> getAnnouncement(){	
		return userService.getAnnouncement();
		
	}

}
