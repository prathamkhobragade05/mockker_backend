package com.softara.mockker.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Announcements")
public class AnnouncementModel{

    @Id
    @Column(name="AnnouncementId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;

    @Column(name="AnnouncementTitle", nullable = false)
    private String announcementTitle;
    
    @Column(name="AnnouncementMessage", nullable = false)
    private String announcementMessage;
    
    @Column(name="CreatedAt", nullable = true)
    private String createdAt;
    
    @Column(name="PostedAt", nullable = true)
    private String postedAt;
    
    @Column(name="isPosted", nullable = true)
    private Boolean isPosted;
   
    
    public AnnouncementModel(Long announcementId,String announcementTitle,String announcementMessage, String createdAt, String postedAt,Boolean isPosted){
    	this.announcementId=announcementId;
    	this.announcementTitle=announcementTitle;
    	this.announcementMessage=announcementMessage;
    	this.createdAt=createdAt;
    	this.postedAt=postedAt;
    	this.isPosted=isPosted;
    };
    public AnnouncementModel() {}
    
    
	public void setAnnouncementId(Long announcementId) {this.announcementId=announcementId;}
	public void setAnnouncementTitle(String announcementTitle) {this.announcementTitle=announcementTitle;}
	public void setAnnouncementMessage(String announcementMessage) {this.announcementMessage=announcementMessage;}
	public void setCreatedAt(String createdAt) {this.createdAt=createdAt;}
	public void setPostedAt(String postedAt) {this.postedAt=postedAt;}
	public void setIsPosted(Boolean isPosted) {this.isPosted=isPosted;}

	public Long getAnnouncementId() {return announcementId;}
	public String getAnnouncementTitle() {return announcementTitle;}
	public String getAnnouncementMessage() {return announcementMessage;}
	public String getCreatedAt() {return createdAt;}
	public String getPostedAt() {return postedAt;}
	public Boolean getIsPosted() {return isPosted;}
}
