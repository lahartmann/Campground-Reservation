package com.techelevator;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

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
	public Reservation createReservation(Reservation newReservation) {
		
		String sqlNewReservaton = "INSERT INTO reservation(reservation_id, site_id, name, from_date, to_date, create_date)"
				+ " VALUES(?, ?, ?, ?, ? ,?)";
		
		newReservation.setReservationId(getNextReservationID());
	
		jdbcTemplate.update(sqlNewReservaton, 
				newReservation.getReservationId(), 
				newReservation.getSiteId(), 
				newReservation.getName(), 
				newReservation.getFromDate(), 
				newReservation.getToDate(), 
				newReservation.getCreateDate());
		
		return newReservation;

		}

	private int getNextReservationID() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_reservation_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getInt(1);
		}else {
			throw new RuntimeException("Something went wrong while getting an id for the new reservation");
		}
	}


	@Override
	public List<Reservation> openSiteSearchPark() {
		ArrayList<Reservation>openSitesPark = new ArrayList<>();
		
		String sqlOpenSItesSearchPark = SELECT 
		
		return null;
	}
	
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> departmentByName = new ArrayList<>();
		
		String sqlGetDepartmentByName = "SELECT * FROM department WHERE name LIKE ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepartmentByName, "%" + nameSearch + "%");
		
		while(results.next()) {
            Department theDepartment = mapRowToDepartment(results);
            departmentByName.add(theDepartment);
        }
		
		return departmentByName;
	}


	@Override
	public List<Reservation> openSiteSearchCampground() {
		// TODO Auto-generated method stub
		return null;
	}
}
