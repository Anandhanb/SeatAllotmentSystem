package main.java.io.nokia.sas.processor;

import main.java.io.nokia.sas.dao.impl.UserDaoImpl;
import main.java.io.nokia.sas.events.RequestAcceptedAndMigrationInitiated;
import main.java.io.nokia.sas.events.SeatClaimedByNewUser;
import main.java.io.nokia.sas.request.SeatChangeRequest;
import main.java.io.nokia.sas.service.notificationservice.NotificationPublisher;

/**
 * The RequestHandler service is responsible for processing the SeatChangeRequest 
 * by getting approval from the Admin and notifying the observers.
 * 
 * @author abalasubramanian
 *
 */
public class RequestHandler implements AbstractProcessor {
	
	private static RequestHandler requestHandler= null;
	
	private NotificationPublisher publisher = NotificationPublisher.getPublisherInstance();
	
	private RequestHandler(){
		
	}
	
	public static RequestHandler getInstance(){
		if(requestHandler == null){
			requestHandler = new RequestHandler();
		}
		return requestHandler;
	}
	
	private UserDaoImpl userDaoImpl = null; 
	
	



	/**
	 * @return the userDaoImpl
	 */
	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}

	/**
	 * @param userDaoImpl the userDaoImpl to set
	 */
	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Override
	public void handleRequest(SeatChangeRequest request) {
		
		if(request.getUser().getSeatId() !=0){
		if(userDaoImpl.getAdminUser().approve(request)){
			publisher.notifyUpdate(new RequestAcceptedAndMigrationInitiated("Admin approved user "+request.getUser().getEmpId()+" seat change request to seat "+ request.getSeat().getSeatId(), 
					request.getUser(), request.getSeat()));
		}
		}else{
			publisher.notifyUpdate(new SeatClaimedByNewUser("Seat: "+request.getSeat().getSeatId()+" claimed by new user "+request.getUser().getEmpId(), request.getUser(), request.getSeat()));
		}

		
		
		
		
		
	}
	
	

}
