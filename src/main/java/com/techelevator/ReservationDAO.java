package com.techelevator;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;
public interface ReservationDAO {

	Reservation createReservation(Reservation newReservation);
	
	
	List<Reservation> openSiteSearchPark();

	List<Reservation> openSiteSearchCampground();
}
