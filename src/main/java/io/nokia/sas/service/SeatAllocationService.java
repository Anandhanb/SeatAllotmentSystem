package main.java.io.nokia.sas.service;

import main.java.io.nokia.sas.events.SeatChangeRequestIntiatedEmptySeat;
import main.java.io.nokia.sas.model.Employee;
import main.java.io.nokia.sas.model.Seat;
import main.java.io.nokia.sas.processor.RequestHandler;
import main.java.io.nokia.sas.request.SeatChangeRequest;
import main.java.io.nokia.sas.service.notificationservice.NotificationPublisher;

/**
 * This service is used to Send a SeatChangeRequest to the handler and add the user to publisher for notifications.
 * 
 * @author abalasubramanian
 *
 */
public class SeatAllocationService {
	
	private RequestHandler requestHandler = RequestHandler.getInstance();
	
	private NotificationPublisher publisher = NotificationPublisher.getPublisherInstance();
	
	public boolean changeSeat(Employee user, Seat seat){
		
		if(user.getSeatId() != 0 && seat.getEmpId() == 0){
			System.out.println("SeatAllocationService:: User initiated seat change");
			publisher.attach(user);
//			System.out.println("SeatAllocationService:: User attached to publisher for events");
			publisher.notifyUpdate(new SeatChangeRequestIntiatedEmptySeat("User "+user.getEmpId()+ " in seat "+user.getSeatId()+" requested change to seat "+seat.getSeatId() ,user, seat));
			requestHandler.handleRequest(new SeatChangeRequest(user, seat));
			System.out.println("SeatAllocationService:: SeatChangeRequest sent and publisher notified");
		}else if (user.getSeatId() == 0){
			System.out.println("SeatAllocationService:: User initiated seat claim");
			publisher.attach(user);
			requestHandler.handleRequest(new SeatChangeRequest(user, seat));	
			System.out.println("SeatAllocationService:: SeatChangeRequest sent");
		}
		return true;
	}	
	

}
