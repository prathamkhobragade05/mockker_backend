package com.softara.mockker.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softara.mockker.model.*;
import com.softara.mockker.service.AdminService;



@RestController
@RequestMapping("mockker/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	 
	@GetMapping("/getOverview")
	public ResponseEntity<?> getOverviewCount(){	
		return adminService.getUsersCount();
	}  
	
	
	@GetMapping("/getActivities")
	public List<ActivitiesModel> getActivites(){	
		return adminService.getActivites();
	}  

	
	@GetMapping("/getUsers")
	public ResponseEntity<?> getUsers(){	
		return ResponseEntity.ok(adminService.getUsers());
		
	}
	@PostMapping("/addTest")																	//---------add question list of question/questionBank
	public Long addTest(@RequestBody TestModel test) {
		TestModel testModel = adminService.addTest(test);
		return testModel.getTestId();
	}
	
	@GetMapping("/getTests")													//---------get list of tests
	public ResponseEntity<List<TestModel>> getListTest() {
		return ResponseEntity.ok(adminService.getListTest());
	}
	
	@GetMapping("/getTest")													//---------get list of tests
	public ResponseEntity<?> getTestById(Long testId) {
		return ResponseEntity.ok(adminService.getTestById(testId));
	}
	
	@PostMapping("/addQuestions")																	//---------add question list of question/questionBank
	public String addListQuestions(@RequestBody List<QuestionModel> question) {
		List<QuestionModel> questionModel = adminService.addQuestionsForTest(question);
		return "QuestionBank Added Successfully"+questionModel.size();
	}
	
	@GetMapping("/getQuestions/{testId}")														//---------get questions by test
	public ResponseEntity<List<QuestionModel>> getQuestionBankByTestId(@PathVariable("testId") Long testId) {
		List<QuestionModel> questionModel= adminService.getQuestionsByTestId(testId);
		return ResponseEntity.ok(questionModel);
	}
	
	@DeleteMapping("/deleteQuestion/{questionId}")
	public boolean deleteQuestionById(@PathVariable("questionId") Long questionId){
		return adminService.deleteQuestionById(questionId);
		
	}
	
	@PutMapping("/updateQuestion/{questionId}")
	public boolean updateQuestionById(@PathVariable("questionId") Long questionId,@RequestBody QuestionModel question) {
		return adminService.updateQuestionById(questionId,question);
	}
	
	@GetMapping("/getAnnouncement")
	public List<AnnouncementModel> getAnnouncement(){	
		return adminService.getAnnouncement();
		
	}
	
	@PostMapping("/addAnnouncement")																	//---------add question list of question/questionBank
	public ResponseEntity<?> addAnnouncement(@RequestBody AnnouncementModel announcement) {
		AnnouncementModel anncoucement=adminService.addAnnouncement(announcement);		
		return ResponseEntity.ok(anncoucement);

	}
	

}
