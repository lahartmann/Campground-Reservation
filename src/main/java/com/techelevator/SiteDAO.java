package com.techelevator;

import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {

	
	public List<Site> getAllSites();

	public List<Site> getAvailableSitesByReservationDate(int campgroundId, LocalDate startDate, LocalDate endDate);

	public Site createSite(Site newSite);
	
	
	

}
