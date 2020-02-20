package com.techelevator;

import java.util.List;



public interface CampgroundDAO {

	
	public List<Campground> getAllCampgrounds();
	
	public List<Campground> searchAllCampgroundsByName(String nameSearch);
	
	public Campground getCampgroundById(int campgroundId);



}
