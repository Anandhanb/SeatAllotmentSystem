package main.java.io.nokia.sas.events;

import main.java.io.nokia.sas.model.Seat;
import main.java.io.nokia.sas.model.User;

/**
 * This event is triggered when a new user / user with no seats associated claims a seat.
 * @author abalasubramanian
 *
 */
public class SeatClaimedByNewUser implements Event {
	
private String message;
	
	private int eventId;
	
	private User user;
	
	private Seat seat;

	/**
	 * @param message
	 * @param eventId
	 * @param user
	 * @param seat
	 */
	public SeatClaimedByNewUser(String message, User user,
			Seat seat) {
		super();
		this.message = message;
		this.eventId = (int) Math.random();
		this.user = user;
		this.seat = seat;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
