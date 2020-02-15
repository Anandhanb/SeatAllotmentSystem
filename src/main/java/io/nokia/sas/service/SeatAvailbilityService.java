package main.java.io.nokia.sas.service;

import java.util.List;
import java.util.Map;

import main.java.io.nokia.sas.dao.impl.SeatDaoImpl;
import main.java.io.nokia.sas.model.Seat;

/**
 * This service is used to find the available seats and all seats by interacting with the DAO.
 * 
 * @author abalasubramanian
 *
 */
public class SeatAvailbilityService {
	
	private SeatDaoImpl seatDaoImpl;
	
	public SeatAvailbilityService(SeatDaoImpl seatDaoImpl){
		this.seatDaoImpl = seatDaoImpl;
	}
	
	public List<Seat> getAllAvailableSeats() {
		return this.seatDaoImpl.getAllAvailableSeats();
	}
	
	public Map<Integer, Seat> getAllSeats(){
		return this.seatDaoImpl.getAllSeats();
	}
	

}
