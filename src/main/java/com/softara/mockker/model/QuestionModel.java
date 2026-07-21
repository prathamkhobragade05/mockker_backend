package com.softara.mockker.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Questions")
public class QuestionModel{

    @Id
    @Column(name="QuestionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long questionId;

    @Column(name="TestId", nullable = false)
    private Long testId;
    
    @Column(name="Question", nullable = false)
    private String question;
    

    @Column(name="SubQuestion", nullable = true)
    private String subQuestion;
    
    @Column(name="Options", nullable = false)
    private List<String> options;
    
    @Column(name="Answer", nullable = false)
    private String answer;

    public QuestionModel(Long questionId,Long testId, String question, String subQuestion, List<String> options, String answer){
    	this.questionId=questionId;
    	this.testId=testId;
    	this.question=question;
    	this.subQuestion=subQuestion;
    	this.options=options;
    	this.answer=answer;
    };
    
    public QuestionModel() {}
    
	public void setQuestionId(Long questionId) {this.questionId=questionId;}
	public void setTestId(Long testId) {this.testId=testId;}
	public void setQuestion(String question) {this.question=question;}
	public void setSubQuestion(String subQuestion) {this.subQuestion=subQuestion;}
	public void setOptions(List<String> options) {this.options=options;}
	public void setAnswer(String answer) {this.answer=answer;}

	public Long getQuestionId() {return questionId;}
	public Long getTestId() {return testId;}
	public String getQuestion() {return question;}
	public String getSubQuestion() {return subQuestion;}
	public List<String> getOptions() {return options;}
	public String getAnswer() {return answer;}
}