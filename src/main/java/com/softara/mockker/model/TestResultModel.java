package com.softara.mockker.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Results")
public class TestResultModel{

    @Id
    @Column(name="ResultId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @Column(name="UserId", nullable = false)
    private Long userId;

    @Column(name="TestId", nullable = false)
    private Long testId;

    @Column(name="Score", nullable = false)
    private double score;					//------total seconds
    
    @Column(name="Percent")
    private double percent;

    @Column(name="Accuracy")
    private double accuracy;

    @Column(name="TimeStamp")
    private String timeStamp;

    

    
    public TestResultModel(Long resultId,Long userId,Long testId,double score, double percent,double accuracy, String timeStamp){
    	this.resultId=resultId;
    	this.userId=userId;
    	this.testId=testId;
    	this.score=score;
    	this.percent=percent;
    	this.accuracy=accuracy;
    	this.timeStamp=timeStamp;
    };
    public TestResultModel() {}
    

	public void setResultId(Long resultId) {this.resultId=resultId;}
	public void setUserId(Long userId) {this.userId=userId;}
	public void setTestId(Long testId) {this.testId=testId;}
	public void setScore(double score) {this.score=score;}
	public void setAccuracy(double accuracy) {this.accuracy=accuracy;}
	public void setPercent(double percent) {this.percent=percent;}
	public void setTimeStamp(String timeStamp) {this.timeStamp=timeStamp;}



	public Long getUserTestId() {return resultId;}
	public Long getUserId() {return userId;}
	public Long getTestId() {return testId;}
	public double getScore() {return score;}
	public double getPercent() {return percent;}
	public double getAccuracy() {return accuracy;}
	public String getTimeStamp() {return timeStamp;}
}