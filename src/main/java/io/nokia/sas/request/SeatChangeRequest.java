package main.java.io.nokia.sas.request;

import main.java.io.nokia.sas.model.Seat;
import main.java.io.nokia.sas.model.User;

/**
 * This POJO is used to request a seat change.
 * 
 * @author abalasubramanian
 *
 */
public class SeatChangeRequest extends AbstractRequest {
	
	private User user;
	
	private Seat seat;

	/**
	 * @param user
	 * @param seat
	 */
	public SeatChangeRequest(User user, Seat seat) {
		super();
		this.user = user;
		this.seat = seat;
	}

	/**
	 * @return the reqId
	 */
	public int getReqId() {
		return reqId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the seat
	 */
	public Seat getSeat() {
		return seat;
	}

	/**
	 * @param seat the seat to set
	 */
	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	}
