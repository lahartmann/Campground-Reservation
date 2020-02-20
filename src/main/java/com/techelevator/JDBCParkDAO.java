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
	public List<Park> getAllParkNames() {
		ArrayList<Park> allParkNames = new ArrayList<>();
		String sqlGetAllParkNames = "SELECT name " + "FROM Park";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParkNames);
		while (results.next()) {
			Park allParks = mapRowToPark(results);
			allParkNames.add(allParks);

		}

		return allParkNames;
	}
	
	
	private Park mapRowToPark(SqlRowSet results) {
		Park allParks = new Park();
		
		allParks.setName(results.getString("name"));
		
		return allParks;
	}

}
