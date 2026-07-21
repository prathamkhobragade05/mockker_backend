package com.softara.mockker.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Activities")
public class ActivitiesModel{

    @Id
    @Column(name="ActivityId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;
 
    @Column(name="ActivityTitle", nullable = false)
    private String activityTitle;
    
    @Column(name="CreatedAt", nullable = false)
    private String createdAt;
    
   
    
    public ActivitiesModel(Long activityId,String activityTitle,String createdAt){
    	this.activityId=activityId;
    	this.activityTitle=activityTitle;
    	this.createdAt=createdAt;
    };
    public ActivitiesModel() {}
    
    
	public void setActivityId(Long announcementId) {this.activityId=announcementId;}
	public void setActivityTitle(String announcementTitle) {this.activityTitle=announcementTitle;}
	public void setCreatedAt(String createdAt) {this.createdAt=createdAt;}

	public Long getActivityId() {return activityId;}
	public String getActivityTitle() {return activityTitle;}
	public String getCreatedAt() {return createdAt;}
}
