package main.java.io.nokia.sas.dao.impl;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import main.java.io.nokia.sas.dao.SeatDao;
import main.java.io.nokia.sas.model.Seat;

/**
 * This pojo represents the SeatDao implementation
 * @author abalasubramanian
 *
 */
public class SeatDaoImpl implements SeatDao{
	
	TreeMap<Integer, Seat> seatsById= new TreeMap<>();
	
	/**
	 * @return the seatsById
	 */
	public TreeMap<Integer, Seat> getSeatsById() {
		return seatsById;
	}

	/**
	 * @param seatsById the seatsById to set
	 */
	public void setSeatsById(TreeMap<Integer, Seat> seatsById) {
		this.seatsById = seatsById;
	}

	@Override
	public List<Seat> getAllAvailableSeats() {		
		
		return this.seatsById.entrySet().stream().filter(e -> e.getValue().isOccupied() == false)
				.map(e -> e.getValue()).collect(Collectors.toList());
	}

	@Override
	public TreeMap<Integer, Seat> getAllSeats() {

		return this.seatsById;
	}

	@Override
	public void updateSeat(int seatId, Seat seat) {		
		
		// TODO Auto-generated method stub
		this.seatsById.put(seatId, seat);
	}
	
	
	
	

}
