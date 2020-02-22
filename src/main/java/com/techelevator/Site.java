package com.techelevator;

public class Site {
	private int siteId;
	private int campgroundID;
	private int siteNumber;
	private int	maxOccupancy;
	private boolean accessible;
	private String maxRvLength;
	private boolean utilities;
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public int getCampgroundID() {
		return campgroundID;
	}
	public void setCampgroundID(int campgroundID) {
		this.campgroundID = campgroundID;
	}
	public int getSiteNumber() {
		return siteNumber;
	}
	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}
	public int getMaxOccupancy() {
		return maxOccupancy;
	}
	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	public String isAccessible() {
		if (accessible) {
			return "Yes";
		}else {
		return "No";
		}
	}
	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}
	public String getMaxRvLength() {
		if (maxRvLength.equals("0")) {
			return "N/A";
		}else {
		return maxRvLength;
		}
	}
	public void setMaxRvLength(String maxRvLength) {
		this.maxRvLength = maxRvLength;
	}
	public String isUtilities() {
		if (utilities) {
			return "Yes";
		}else {
		return "No";
		}
	}
	public void setUtilities(boolean utilities) {
		this.utilities = utilities;
	}
	
	

}
