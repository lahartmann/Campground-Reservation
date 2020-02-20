package com.techelevator;

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
