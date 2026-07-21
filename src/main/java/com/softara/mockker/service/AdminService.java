package com.softara.mockker.service;

import java.sql.Timestamp; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softara.mockker.model.*;
import com.softara.mockker.repository.*;



@Service
public class AdminService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TestRepository testRepo;
	
	@Autowired
	QuestionRepository questionRepo;
	
	@Autowired
	AnnouncementRepository announcementRepo;
	
	@Autowired
	ActivitiesRepository activityRepo;

	
	public ResponseEntity<?> getUsersCount() {
		
		Map<String, Long> response = new HashMap<>();
	    response.put("userCount", userRepo.count());
	    response.put("testCount", testRepo.count());

	    return ResponseEntity.ok(response);
	}
	
	public List<ActivitiesModel> getActivites() {
		return activityRepo.findAll();
	}
	
	public List<UserModel> getUsers() {
		return userRepo.findAll();
	}

	public TestModel addTest(TestModel test) {
		return testRepo.save(test);
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

	public boolean deleteQuestionById(Long questionId) {
		if (questionRepo.existsById(questionId)) {
	        questionRepo.deleteById(questionId);
	        addActivity("Question with id "+questionId+" deleted.");
	        return true;
	    }
	    return false;
	}

	public boolean updateQuestionById(Long questionId,QuestionModel updateQuestion) {
		QuestionModel question=questionRepo.findById(questionId).orElseThrow(() -> new RuntimeException("Question Not Found"));
		if(question!=null) {
//			question.setTestId(updateQuestion.getTestId());
			question.setQuestion(updateQuestion.getQuestion());
//			question.setSubQuestion(updateQuestion.getSubQuestion());
			question.setOptions(updateQuestion.getOptions());
			question.setAnswer(updateQuestion.getAnswer());
			questionRepo.save(question);
			
			addActivity("Question with id "+questionId+" updated.");
			return true;
		}

	    return false;
	}

	public List<QuestionModel> addQuestionsForTest(List<QuestionModel> question) {
		return questionRepo.saveAll(question);
	}

	public AnnouncementModel addAnnouncement(AnnouncementModel announcement) {
		Timestamp createdAt=new Timestamp(System.currentTimeMillis());
		announcement.setCreatedAt(createdAt.toString());
		AnnouncementModel announcementModel=announcementRepo.save(announcement);

		addActivity("New Annoucement created id:"+announcementModel.getAnnouncementId());
		return announcementModel;
	}

	public List<AnnouncementModel> getAnnouncement() {
		return announcementRepo.findAll();
	}
	public void addActivity(String title) {
		ActivitiesModel activity = new ActivitiesModel();
		Timestamp createdAt=new Timestamp(System.currentTimeMillis());
		
		activity.setActivityTitle(title);
		activity.setCreatedAt(createdAt.toString());
		activityRepo.save(activity);
	}

	

	
		
}
