package main.java.io.nokia.sas;

import main.java.io.nokia.sas.dao.impl.SeatDaoImpl;
import main.java.io.nokia.sas.dao.impl.UserDaoImpl;
import main.java.io.nokia.sas.model.Admin;
import main.java.io.nokia.sas.model.Employee;
import main.java.io.nokia.sas.model.Seat;
import main.java.io.nokia.sas.processor.RequestHandler;
import main.java.io.nokia.sas.service.FacilityManagement;
import main.java.io.nokia.sas.service.SeatAllocationService;
import main.java.io.nokia.sas.service.SeatAvailbilityService;
import main.java.io.nokia.sas.service.UserService;
import main.java.io.nokia.sas.service.notificationservice.NotificationPublisher;

public class App {
	
	public static void main(String[] args) {
		// generate User and Seat datas
		UserDaoImpl userDao = DataSimulator.generateUsers(new UserDaoImpl());
		SeatDaoImpl seatDao = DataSimulator.generateSeats(new SeatDaoImpl());

		// Instantiate all the Services
		UserService userService = new UserService(userDao);
		SeatAvailbilityService seatAvailbilityService = new SeatAvailbilityService(
				seatDao);
		SeatAllocationService seatAllocationService = new SeatAllocationService();
		FacilityManagement facilityManagement = new FacilityManagement(userDao,
				seatDao);

		NotificationPublisher publisher = NotificationPublisher
				.getPublisherInstance();
		Admin admin = userService.getAdminUser();
		publisher.attach(admin);
		publisher.attach(facilityManagement);

		RequestHandler requestHandler = RequestHandler.getInstance();
		requestHandler.setUserDaoImpl(userDao);

		// UseCase 1
		System.out
				.println("UseCase 1: New/User without a seat claiming a vacant seat");
		System.out
				.println("---------------------------------------------------------");
		Employee employee2 = userService.getAllEmployees().get(3);
		Seat seat2 = seatAvailbilityService.getAllSeats().get(2);

		seatAllocationService.changeSeat(employee2, seat2);

		System.out.println("********************Complete********************"
				+ "\n");

		// UseCase 2
		System.out.println("UseCase 2: Old user requesting a vacant seat.");
		System.out.println("---------------------------------------------");
		Employee employee1 = userService.getAllEmployees().get(4);
		Seat seat1 = seatAvailbilityService.getAllSeats().get(3);

		seatAllocationService.changeSeat(employee1, seat1);

		System.out.println("********************Complete********************"
				+ "\n");
		
		// UseCase 1
				System.out
						.println("UseCase 1: New/User without a seat claiming a vacant seat");
				System.out
						.println("---------------------------------------------------------");
				Employee employee3 = userService.getAllEmployees().get(2);
				Seat seat3 = seatAvailbilityService.getAllSeats().get(1);

				seatAllocationService.changeSeat(employee3, seat3);

				System.out.println("********************Complete********************"
						+ "\n");

				// UseCase 2
				System.out.println("UseCase 2: Old user requesting a vacant seat.");
				System.out.println("---------------------------------------------");
				Employee employee4 = userService.getAllEmployees().get(9);
				Seat seat4 = seatAvailbilityService.getAllSeats().get(8);

				seatAllocationService.changeSeat(employee4, seat4);

				System.out.println("********************Complete********************"
						+ "\n");


	}

}
