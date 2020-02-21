package com.techelevator;

import java.util.List;

public class Campground {
	
	private int campgroundId;
	private int parkId;
	private String name;
	private String openDate;
	private String closeDate;
	private int dailyFee;
	
	public int getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
	}
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
		
	public String getCloseDate() {
			return closeDate;
		}
	public void setCloseDate(String openDate) {
			this.closeDate = openDate;
	}
	public int getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(int dailyFee) {
		this.dailyFee = dailyFee;
	}
	public static List<Campground> getCampgroundById(int park_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
