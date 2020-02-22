package com.techelevator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;
public interface ReservationDAO {

	


	public Reservation createReservation(int siteId, String name, LocalDate startDate, LocalDate endDate);
}
