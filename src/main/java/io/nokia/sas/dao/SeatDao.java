package main.java.io.nokia.sas.dao;

import java.util.List;
import java.util.TreeMap;

import main.java.io.nokia.sas.model.Seat;

public interface SeatDao {
	
	List<Seat> getAllAvailableSeats();
	
	TreeMap<Integer, Seat> getAllSeats();
	
	public void updateSeat(int seatId, Seat seat);
	

}
