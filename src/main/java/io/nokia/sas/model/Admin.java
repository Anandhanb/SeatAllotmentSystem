package main.java.io.nokia.sas.model;

import main.java.io.nokia.sas.events.Event;
import main.java.io.nokia.sas.request.SeatChangeRequest;
import main.java.io.nokia.sas.service.notificationservice.Observer;

/**
 * This pojo represents the Admin User with all the required and optional fields.
 * 
 * @author abalasubramanian
 *
 */
public class Admin implements User, Observer{
	
	private int empId;
	
	private int seatId;
	
	private String empName;
	
	private boolean isActive;
	
	private int roleId;
	
	/**
	 * @param empId
	 * @param seatId
	 * @param empName
	 * @param isActive
	 * @param roleId
	 */
	public Admin(int empId, int seatId, String empName, boolean isActive,
			int roleId) {
		super();
		this.empId = empId;
		this.seatId = seatId;
		this.empName = empName;
		this.isActive = isActive;
		this.roleId = roleId;
	}

	public Admin(){
		
	}

	/**
	 * @param empId
	 * @param seatId
	 * @param empName
	 * @param isActive
	 */
	public Admin(int empId, int seatId, String empName, boolean isActive) {
		super();
		this.empId = empId;
		this.seatId = seatId;
		this.empName = empName;
		this.isActive = isActive;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the seatId
	 */
	public int getSeatId() {
		return seatId;
	}

	/**
	 * @param seatId the seatId to set
	 */
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public void update(Event event) {
		System.out.println("Admin notified of event: "+event.getMessage());
	}
	
	public boolean approve(SeatChangeRequest request){
		
		//TODO: add approval logic
		
		return true;
		
	}

}
