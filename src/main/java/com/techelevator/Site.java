package com.techelevator;

public class Site {
	private int siteId;
	private int campgroundID;
	private int siteNumber;
	private int	maxOccupancy;
	private boolean accessible;
	private int maxRvLength;
	private boolean utilites;
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
	public boolean isAccessible() {
		return accessible;
	}
	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}
	public int getMaxRvLength() {
		return maxRvLength;
	}
	public void setMaxRvLength(int maxRvLength) {
		this.maxRvLength = maxRvLength;
	}
	public boolean isUtilites() {
		return utilites;
	}
	public void setUtilites(boolean utilites) {
		this.utilites = utilites;
	}
	
	

}
