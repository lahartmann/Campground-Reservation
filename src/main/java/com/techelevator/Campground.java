package com.techelevator;

import java.math.BigDecimal;


public class Campground {
	
	private int campgroundId;
	private int parkId;
	private String name;
	private String openDate;
	private String closeDate;
	private BigDecimal dailyFee = new BigDecimal(0);
	
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
	public BigDecimal getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(BigDecimal dailyFee) {
		this.dailyFee = dailyFee;
	}
	
	}
	
	
	
	


