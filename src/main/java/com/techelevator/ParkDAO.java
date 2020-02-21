package com.techelevator;

import java.util.List;

public interface ParkDAO {

	
	List<Park> getAllParks();

	Park getParkByNameAndState(String string, String string2);
}
