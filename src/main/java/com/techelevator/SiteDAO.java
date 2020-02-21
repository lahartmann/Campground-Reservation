package com.techelevator;

import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {

	
	public List<Site> getAllSites();

	List<Site> getAvailableSitesByReservationDate(int campgroundId, LocalDate startDate, LocalDate endDate);
	
	
	

}
