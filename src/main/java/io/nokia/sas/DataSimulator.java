package main.java.io.nokia.sas;

import java.util.Map;
import java.util.TreeMap;

import main.java.io.nokia.sas.dao.impl.SeatDaoImpl;
import main.java.io.nokia.sas.dao.impl.UserDaoImpl;
import main.java.io.nokia.sas.model.Admin;
import main.java.io.nokia.sas.model.Employee;
import main.java.io.nokia.sas.model.Seat;
import main.java.io.nokia.sas.model.SeatImpl;
import main.java.io.nokia.sas.model.User;

public class DataSimulator {
	
	public static UserDaoImpl generateUsers(UserDaoImpl userDaoImpl){
		
		
		Map<Integer, User> userMap = new TreeMap<>();
		
		for(int i=1; i<=20;i++){
		
			if(i%5==0){
				userMap.put(i, new Employee(i, i, "Emp"+i, true,1));
			}else{
			userMap.put(i, new Employee(i, 0, "Emp"+i, true,1));
			}
		}
		
		userMap.put(21, new Admin(21, 21, "Administrator", true,2));
		userDaoImpl.setUsers(userMap);	
		
		return userDaoImpl;
	}
	
	public static SeatDaoImpl generateSeats(SeatDaoImpl seatDaoImpl){
		
		TreeMap<Integer, Seat> seatMap = new TreeMap<>();
		
		for(int i=1;i<=20;i++){
			if(i%5 ==0){
				seatMap.put(i, new SeatImpl(i,1,"Nokia",true,i));
			}else{
				seatMap.put(i, new SeatImpl(i,1,"Nokia",false,0));
			}
		}
		seatDaoImpl.setSeatsById(seatMap);
		
		return seatDaoImpl;
	}
	
}
