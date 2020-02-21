package com.techelevator;

import java.util.List;

public interface ParkDAO {

	
	

	public Park getParkByNameAndState(String string, String string2);

	List<Park> getAllParkNames();
}
