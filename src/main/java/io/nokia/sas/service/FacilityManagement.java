package main.java.io.nokia.sas.service;

import main.java.io.nokia.sas.dao.impl.SeatDaoImpl;
import main.java.io.nokia.sas.dao.impl.UserDaoImpl;
import main.java.io.nokia.sas.events.Event;
import main.java.io.nokia.sas.events.MigrationCompletedAndOccupied;
import main.java.io.nokia.sas.events.RequestAcceptedAndMigrationInitiated;
import main.java.io.nokia.sas.events.SeatClaimedByNewUser;
import main.java.io.nokia.sas.model.Employee;
import main.java.io.nokia.sas.model.Seat;
import main.java.io.nokia.sas.model.User;
import main.java.io.nokia.sas.service.notificationservice.NotificationPublisher;
import main.java.io.nokia.sas.service.notificationservice.Observer;


/**
 * This Service acts as a FacilityManager and takes care of migrating the employees and their assets and notifies the stakeholders accordingly.
 * 
 * @author abalasubramanian
 *
 */
public class FacilityManagement implements Observer{
	
	private UserDaoImpl userDao;
	
	private SeatDaoImpl seatDao;
	
	private NotificationPublisher publisher = NotificationPublisher.getPublisherInstance();
	
	public FacilityManagement(UserDaoImpl userDao, SeatDaoImpl seatDao){
		this.userDao = userDao;
		this.seatDao = seatDao;
	}

	@Override
	public void update(Event event) {
		
		if(event instanceof RequestAcceptedAndMigrationInitiated){
			
			RequestAcceptedAndMigrationInitiated requestAccepted = (RequestAcceptedAndMigrationInitiated) event;
			User user =requestAccepted.getUser();
			int userId = user.getEmpId();
			
			Seat seat =requestAccepted.getSeat();
			int seatId = user.getSeatId();
			
			//Updating the user and userDao with new seat Id
			user.setSeatId(seat.getSeatId());
			userDao.updateUser(userId, user);
			
//			System.out.println("Seat Id Updated in user");
			
			//Update the seat and seatDao with new userId
			
			seat.setEmpId(userId);
			seat.setOccupied(true);
			seatDao.updateSeat(seatId, seat);
			
			System.out.println("FacilityManager: updated seatId in User and userId in Seat");
			
			publisher.notifyUpdate(new MigrationCompletedAndOccupied("Migration for user "+
			userId+" to seat "+seatId+"completed all assets transfered", user, seat));		
			
			publisher.detach((Employee) requestAccepted.getUser());
			
		}
		if(event instanceof SeatClaimedByNewUser){
			SeatClaimedByNewUser seatClaimRequest = (SeatClaimedByNewUser) event;
			
			User user =seatClaimRequest.getUser();
			int userId = user.getEmpId();
			Seat seat =seatClaimRequest.getSeat();
			int seatId = user.getSeatId();
			
			//Updating the user and userDao with new seat Id
			user.setSeatId(seat.getSeatId());
			userDao.updateUser(userId, user);
			
//			System.out.println("Seat Id Updated in user");
			
			//Update the seat and seatDao with new userId
			
			seat.setEmpId(userId);
			seatDao.updateSeat(seatId, seat);
			
			System.out.println("FacilityManager: updated seatId in User and userId in Seat");
			
			publisher.notifyUpdate(new MigrationCompletedAndOccupied("Migration for new user "+
			userId+" to seat"+seatId+" completed all assets transfered", user, seat));		
			
			publisher.detach((Employee) seatClaimRequest.getUser());
			
		}
		
		
	}

}
