package main.java.io.nokia.sas.model;

/**
 * This pojo represents seat with all the required and optional fields.
 * 
 * @author abalasubramanian
 *
 */
public class SeatImpl implements Seat {
	
	private int seatId;
	
	private int floorNumber;
	
	private String companyName;
	
	private boolean isOccupied;
	
	private int empId;
	
	public SeatImpl(){
		
	}

	/**
	 * @param seatId
	 * @param floorNumber
	 * @param companyName
	 * @param isOccupied
	 * @param empId
	 */
	public SeatImpl(int seatId, int floorNumber, String companyName,
			boolean isOccupied, int empId) {
		super();
		this.seatId = seatId;
		this.floorNumber = floorNumber;
		this.companyName = companyName;
		this.isOccupied = isOccupied;
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
	 * @return the floorNumber
	 */
	public int getFloorNumber() {
		return floorNumber;
	}

	/**
	 * @param floorNumber the floorNumber to set
	 */
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the isOccupied
	 */
	public boolean isOccupied() {
		return isOccupied;
	}

	/**
	 * @param isOccupied the isOccupied to set
	 */
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
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

}
