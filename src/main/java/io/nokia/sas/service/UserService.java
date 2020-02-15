package main.java.io.nokia.sas.service;

import java.util.List;
import java.util.Map;

import main.java.io.nokia.sas.dao.impl.UserDaoImpl;
import main.java.io.nokia.sas.model.Admin;
import main.java.io.nokia.sas.model.Employee;
import main.java.io.nokia.sas.model.User;

/**
 * This service is used get the list of Users, Employees and Admin from the Dao.
 * @author abalasubramanian
 *
 */
public class UserService {
	
	private UserDaoImpl userdao;
	
	public UserService(UserDaoImpl userdao){
		this.userdao = userdao;
	}
	
	public Map<Integer, User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.userdao.getAllUsers();
	}
	
	
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.userdao.getAllEmployees();
	}

	
	public Admin getAdminUser() {
		// TODO Auto-generated method stub
		return this.userdao.getAdminUser();
	}
	

}
