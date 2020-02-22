package com.techelevator;

import org.springframework.jdbc.support.rowset.SqlRowSet;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCReservationDAO implements ReservationDAO {
	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public int createReservation(int siteId, String name, LocalDate startDate, LocalDate endDate) {
		
		String sqlNewReservaton = "INSERT INTO reservation(reservation_id, site_id, name, from_date, to_date, create_date)"
				+ " VALUES(?, ?, ?, ?, ? ,?)";
		
		Reservation newReservation = new Reservation();
		newReservation.setReservationId(getNextReservationID());
		newReservation.setSiteId(siteId);
		newReservation.setName(name);
		newReservation.setFromDate(startDate);
		newReservation.setToDate(endDate);
		newReservation.setCreateDate(LocalDate.now());
		
		
	
		jdbcTemplate.update(sqlNewReservaton, 
				newReservation.getReservationId(), 
				newReservation.getSiteId(), 
				newReservation.getName(), 
				newReservation.getFromDate(), 
				newReservation.getToDate(), 
				newReservation.getCreateDate());
		
		return newReservation.getReservationId();

		}

	private int getNextReservationID() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('reservation_reservation_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getInt(1);
		}else {
			throw new RuntimeException("Something went wrong while getting an id for the new reservation");
		}
	}





}
