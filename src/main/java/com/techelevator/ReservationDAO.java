package com.techelevator;

import org.springframework.jdbc.support.rowset.SqlRowSet;



@Override
public Reservation createReservation(Reservation newReservation) {
	
	String sqlNewReservaton = "INSERT INTO reservation(dreservation_id, site_id, name, from_date, to_date, create_date)"
			+ " VALUES(?, ?, ?, ?, ? ,?)";
	
	newReservation.setId(getNextReservationID() );
	
	jdbcTemplate.update(sqlNewReservation, newReservation.getId(), newReservation.getName());
	
	return newReservation;

	}
}
