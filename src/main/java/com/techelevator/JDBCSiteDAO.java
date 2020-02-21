package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;




public class JDBCSiteDAO implements SiteDAO {
	
	private JdbcTemplate jdbcTemplate;
	  
	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Site> getAllSites() {
		ArrayList<Site> siteList = new ArrayList<>();
		String sqlGetAllSites = "SELECT site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilites " + "FROM site";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllSites);
		while (results.next()) {
			Site allSites = mapRowToSites(results);
			siteList.add(allSites);

		}

		return siteList;
	}

	@Override
	public List<Site> getAvailableSitesByReservationDate(int campgroundId, LocalDate fromDate, LocalDate toDate) {
		List<Site> availableSites = new ArrayList<Site>();
		String sqlGetFiveAvailableSites = "SELECT * FROM site " + 
				"JOIN campground on site.campground_id = campground.campground_id " + 
				"WHERE site.campground_id = ? " + 
				"and site_id not in " + 
				"(SELECT site.site_id from site " + 
				"JOIN reservation ON reservation.site_id = site.site_id " + 
				"WHERE ? > reservation.from_date and ? < reservation.to_date) " + 
				//"ORDER BY XXXXXXX " + //what do we want to order by???
				"LIMIT 5";
		Site theSite;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetFiveAvailableSites, campgroundId, fromDate, toDate);
		while(results.next()) {
			theSite = mapRowToSites(results); //Should I be mapping everything from the joined tables?
			availableSites.add(theSite);
		}
		return  availableSites;
	}
	

	
	private Site mapRowToSites(SqlRowSet results) {
		Site allSites = new Site();
		allSites.setSiteId(results.getInt("site_id"));
		allSites.setCampgroundID(results.getInt("campground_id"));
		allSites.setSiteNumber(results.getInt("site_number"));
		allSites.setMaxOccupancy(results.getInt("max_occupancy"));
		allSites.setAccessible(results.getBoolean("accessible"));
		allSites.setMaxRvLength(results.getInt("max_rv_length"));
		allSites.setUtilites(results.getBoolean("utilities"));

		return allSites;
	}
}
