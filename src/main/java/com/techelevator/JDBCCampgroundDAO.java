package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;



public class JDBCCampgroundDAO implements CampgroundDAO  {

	
	private JdbcTemplate jdbcTemplate;
	  
	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	@Override
	public List<Campground> getAllCampgrounds() {
		ArrayList<Campground> campgroundList = new ArrayList<>();
		String sqlGetAllCampgrounds = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee " + "FROM department";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCampgrounds);
		while (results.next()) {
			Campground allCampgrounds = mapRowToCampground(results);
			campgroundList.add(allCampgrounds);

		}

		return campgroundList;
	}

	@Override
	public List<Campground> searchAllCampgroundsByName(String nameSearch) {
		ArrayList<Campground> searchCampgroundByName = new ArrayList<>();
		String sqlsearchCampground = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee " + "WHERE  name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlsearchCampground, nameSearch);
		while (results.next()) {
			Campground campgroundSearches = mapRowToCampground(results);
			searchCampgroundByName.add(campgroundSearches);

		}
		return searchCampgroundByName;
	}

	@Override
	public Campground getCampgroundById(int campgroundId) {
		
		String sqlFindCampgroundById = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee " + "FROM campground " + "WHERE campground_id = ?";

			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCampgroundById, campgroundId);
				
			Campground campgroundIdResults = new Campground();
			if (results.next()){
				campgroundIdResults = mapRowToCampground(results);
			
		}
			return campgroundIdResults;
	}
	
	@Override
	public List<Campground> getCampgroundByParkId(int parkId) {
		List<Campground> campgrounds = new ArrayList<Campground>();
		String sqlGetCampgroundsByParkId = "SELECT * FROM campground WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCampgroundsByParkId, parkId);
		while(results.next()) {
			Campground theCampground = mapRowToCampground(results);
			campgrounds.add(theCampground);
		}
		return campgrounds;
	} 
	
	
	private Campground mapRowToCampground(SqlRowSet results) {
		Campground allCampgrounds = new Campground();
		allCampgrounds.setCampgroundId(results.getInt("campground_id"));
		allCampgrounds.setParkId(results.getInt("park_id"));
		allCampgrounds.setName(results.getString("name"));
		allCampgrounds.setOpenDate(results.getString("open_from_mm"));
		allCampgrounds.setCloseDate(results.getString("open_to_mm"));;
		allCampgrounds.setDailyFee(results.getInt("daily_fee"));

		return allCampgrounds;
	}

}
