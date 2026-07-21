package com.softara.mockker.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Tests")
public class TestModel{

    @Id
    @Column(name="TestId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    @Column(name="TestName", nullable = false)
    private String testName;
    
    @Column(name="TotalQuestions", nullable = false)
    private int totalQuestions;
    
    
    @Column(name="Duration", nullable = false)
    private int duration;
    
//    @Column(name="Category", nullable = false)
//    private String category;



    
    public TestModel(Long testId,String testName, int totalQuestions, int duration){
    	this.testId=testId;
    	this.testName=testName;
    	this.totalQuestions=totalQuestions;
    	this.duration=duration;
//    	this.category=category;
    };
    public TestModel() {}
    
    
	public void setTestId(Long testId) {this.testId=testId;}
	public void setTestName(String testName) {this.testName=testName;}
	public void setTotalQuestions(int totalQuestions) {this.totalQuestions=totalQuestions;}
	public void setDuration(int duration) {this.duration=duration;}
//	public void setCategory(String category) {this.category=category;}

	public Long getTestId() {return testId;}
	public String getTestName() {return testName;}
	public int getTotalQuestions() {return totalQuestions;}
	public int getDuration() {return duration;}
//	public String getCategory() {return category;}
}