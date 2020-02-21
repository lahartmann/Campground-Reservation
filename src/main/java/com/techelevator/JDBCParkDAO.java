package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO {

	
	private JdbcTemplate jdbcTemplate;
	  
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	@Override
	public List<Park> getAllParks() {
		ArrayList<Park> allParksList = new ArrayList<>();
		String sqlGetAllParkNames = "SELECT * " + "FROM Park " + "ORDER BY name";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParkNames);
		while (results.next()) {
			Park allParks = mapRowToPark(results);
			allParksList.add(allParks);

		}

		return allParksList;
	}
	
	
	private Park mapRowToPark(SqlRowSet results) {
		Park allParks = new Park();
		
		allParks.setName(results.getString("name"));
		
		return allParks;
	}

	@Override
	public Park getParkByNameAndState(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

}
