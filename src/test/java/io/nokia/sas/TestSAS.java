package test.java.io.nokia.sas;

import static org.junit.Assert.assertTrue;
import main.java.io.nokia.sas.DataSimulator;
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

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestSAS {
	
	private UserDaoImpl userDao = DataSimulator.generateUsers(new UserDaoImpl());
	private SeatDaoImpl seatDao = DataSimulator.generateSeats(new SeatDaoImpl());

	private UserService userService = new UserService(userDao);
	private SeatAvailbilityService seatAvailbilityService =new SeatAvailbilityService(
			seatDao);
	private SeatAllocationService seatAllocationService = new SeatAllocationService();
	
	
	
	
	private FacilityManagement facilityManagement = new FacilityManagement(userDao,
			seatDao);
	
	private NotificationPublisher publisher = NotificationPublisher
			.getPublisherInstance();
	
	
	private RequestHandler requestHandler = RequestHandler.getInstance();
	
	Admin admin = userService.getAdminUser();
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	

	public void addListeners(){
		publisher.attach(admin);
		publisher.attach(facilityManagement);
		requestHandler.setUserDaoImpl(userDao);
	}
	@Test
	public void testCase1() {
		
//		fail("Not yet implemented");
		
		
//		thrown.expect(NullPointerException.class);
		
		// UseCase 1 new user without a seat claiming a vacant seat
		
		addListeners();
				System.out
						.println("UseCase 1: New/User without a seat claiming a vacant seat");
				System.out
						.println("---------------------------------------------------------");
				Employee employee2 = userService.getAllEmployees().get(3);
				Seat seat2 = seatAvailbilityService.getAllSeats().get(2);

				assertTrue(seatAllocationService.changeSeat(employee2, seat2));

				System.out.println("********************Complete********************"
						+ "\n");
		
	}
	
	@Test
	public void testCase2() {
		
		System.out.println("UseCase 2: Old user requesting a vacant seat.");
		System.out.println("---------------------------------------------");
		Employee employee1 = userService.getAllEmployees().get(4);
		Seat seat1 = seatAvailbilityService.getAllSeats().get(3);

		assertTrue(seatAllocationService.changeSeat(employee1, seat1));

		System.out.println("********************Complete********************"
				+ "\n");

	}
	
	@Test
	public void testCase3() {
		thrown.expect(RuntimeException.class);
		System.out.println("testing non existing user");
		System.out.println("---------------------------------------------");
		Employee employee1 = userService.getAllEmployees().get(25);
		Seat seat1 = seatAvailbilityService.getAllSeats().get(3);

		assertTrue(seatAllocationService.changeSeat(employee1, seat1));

		System.out.println("********************Complete********************"
				+ "\n");

	}
	
	@Test
	public void testCase4() {
		thrown.expect(RuntimeException.class);
		System.out.println("testing null user");
		System.out.println("---------------------------------------------");
		Employee employee1 = userService.getAllEmployees().get(4);
		Seat seat1 = seatAvailbilityService.getAllSeats().get(3);

		assertTrue(seatAllocationService.changeSeat(null, seat1));

		System.out.println("********************Complete********************"
				+ "\n");

	}

	
	
}
