package main.java.io.nokia.sas.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import main.java.io.nokia.sas.dao.UserDao;
import main.java.io.nokia.sas.model.Admin;
import main.java.io.nokia.sas.model.Employee;
import main.java.io.nokia.sas.model.User;
/**
 * This POJO represents User Dao implementation.
 * @author abalasubramanian
 *
 */
public class UserDaoImpl implements UserDao {
	
	private Map<Integer, User> users = new TreeMap<>();
	
	
	
	/**
	 * @return the users
	 */
	public Map<Integer, User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Map<Integer, User> users) {
		this.users = users;
	}

	public void updateUser(int userId, User user){
		this.users.put(userId, user);
	}
	
	/**
	 * @return returns a list of Users.
	 */
	public Map<Integer, User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.users;
	}
	
	/**
	 * 
	 * @return returns a list segragating employees from all the users.
	 */
	public List<Employee> getAllEmployees() {
		
		return this.users.entrySet().stream().filter(e -> e.getValue().getRoleId() ==1).map(e -> (Employee) e.getValue()).collect(Collectors.toList());

	}

	/**
	 * @return returns the AdminUser.
	 */
	@Override
	public Admin getAdminUser() {
		
		return this.users.entrySet().stream().filter(e -> e.getValue().getRoleId() ==2).map(e -> (Admin) e.getValue()).collect(Collectors.toList()).get(0);
		
	}


}
