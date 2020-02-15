package main.java.io.nokia.sas.service.notificationservice;

import main.java.io.nokia.sas.events.Event;

public interface Notification {
	
	public void attach(Observer o);
    public void detach(Observer o);
    public void notifyUpdate(Event event);

}
