package main.java.io.nokia.sas.dao;

import java.util.Map;

import main.java.io.nokia.sas.model.Admin;
import main.java.io.nokia.sas.model.User;

public interface UserDao {
	
	Map<Integer, User> getAllUsers() ;
	
	Admin getAdminUser();
	

}
