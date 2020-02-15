package main.java.io.nokia.sas.processor;

import main.java.io.nokia.sas.request.SeatChangeRequest;

public interface AbstractProcessor {
	
	public void handleRequest(SeatChangeRequest request);

}
