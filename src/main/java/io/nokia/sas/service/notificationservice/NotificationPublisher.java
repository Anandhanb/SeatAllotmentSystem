package main.java.io.nokia.sas.service.notificationservice;

import java.util.ArrayList;
import java.util.List;

import main.java.io.nokia.sas.events.Event;

/**
 * The publisher service is responsible for attaching, detaching and notifying observers.
 * @author abalasubramanian
 *
 */
public class NotificationPublisher implements Notification{
	
	private static NotificationPublisher publisher = null;
	
	private NotificationPublisher(){
		
	}
	
	public static NotificationPublisher getPublisherInstance(){
		
		if(publisher == null){
			publisher = new NotificationPublisher();
		}
		return publisher;
	}
	
	private List<Observer> observers = new ArrayList<>();
	 
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
 
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
 
    @Override
    public void notifyUpdate(Event event) {
        for(Observer o: observers) {
            o.update(event);
        }
    }

}
