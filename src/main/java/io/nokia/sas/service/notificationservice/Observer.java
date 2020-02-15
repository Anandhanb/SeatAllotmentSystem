package main.java.io.nokia.sas.service.notificationservice;

import main.java.io.nokia.sas.events.Event;

public interface Observer {
	
	public void update(Event event);

}
