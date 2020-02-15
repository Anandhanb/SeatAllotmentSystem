package main.java.io.nokia.sas.events;

public interface Event {
	
	String getMessage();
	void setMessage(String message);
	
	int getEventId();
	void setEventId(int eventId);

}
