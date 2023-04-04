package com.example.model;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;


public class Customer {
	private Long id;
    private String name;
    
    private String duetime; 
    private String jointime;
    
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", duetime=" + duetime + ", jointime=" + jointime + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuetime() {
		return duetime;
	}
	public void setDuetime(String duetime) {
		this.duetime = duetime;
	}
	public String getJointime() {
		return jointime;
	}
	public void setJointime(String jointime) {
		this.jointime = jointime;
	}
    
	
    
}
