package com.techelevator;

import java.time.LocalDate;

public class Park {

	private int parkId;
	private String name;
	private String location;
	private LocalDate establishDate;
	private int area;
	private int visitors;
	private String description;
	
	
	public int getPark_id() {
		return parkId;
	}
	public void setPark_id(int park_id) {
		this.parkId = park_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getEstablish_date() {
		return establishDate;
	}
	public void setEstablish_date(LocalDate establish_date) {
		this.establishDate = establish_date;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getVisitors() {
		return visitors;
	}
	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
