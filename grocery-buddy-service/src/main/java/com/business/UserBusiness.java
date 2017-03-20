/**
 * Business layer facade for User stories 
 */
package com.business;

import java.util.List;

import com.domain.business.UserBO;

/**
 * @author jay
 *
 */
public interface UserBusiness {
	/**Insert a user*/
	public void addUser(UserBO user);
	
	/**Update a user*/
	public void updateUser(UserBO user);
	
	/**Gets all Users from the database*/
	public List<UserBO> getAllUsers(); 
	
	/**Gets a user given the user Id*/
	public UserBO getUserById(int userId);
	
	/** Lets the user login the application */
	public UserBO loginUser(String userName, String password);
	
	/** removes a user from the database */
	public void removeUser(int userId);
	
}
