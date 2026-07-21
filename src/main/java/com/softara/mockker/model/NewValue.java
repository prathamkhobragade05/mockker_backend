package com.softara.mockker.model;

public class NewValue {
	private Long userId;
	private String field;
	private String value;
	
	NewValue(Long userId,String field, String value){
		this.userId=userId;
		this.field=field;
		this.value=value;
	}
	
	NewValue(){}

	public Long getUserId() {return userId;}
	public String getField() {return field;}
	public String getValue() {return value;}

	public void setUserId(Long userId) {this.userId = userId;}
	public void setField(String field) {this.field = field;}
	public void setValue(String value) {this.value = value;}
	
}
