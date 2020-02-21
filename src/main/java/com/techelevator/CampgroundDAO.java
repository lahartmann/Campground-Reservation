package com.techelevator;

import java.util.List;



public interface CampgroundDAO {

	
	public List<Campground> getAllCampgrounds();
	
	public List<Campground> searchAllCampgroundsByName(String nameSearch);
	
	public Campground getCampgroundById(int campgroundId);

	public List<Campground> getCampgroundByParkId(int parkId);

	public Campground createCampground(Campground newCamp);



}
