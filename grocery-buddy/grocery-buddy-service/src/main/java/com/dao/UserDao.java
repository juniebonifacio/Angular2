/**
 * Data Access Object for User Story data transactions
 */
package com.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.domain.hibernate.UserVO;

/**
 * @author g.s.cuizon
 *
 */
public interface UserDao {
	
	/**Insert a user */
	public void addUser(UserVO user);
	
	/**Update a user */
	public void updateUser(UserVO user);
	
	/**Gets all User from the database*/
	public List<UserVO> getAllUsers(); 
	
	/**Gets a user given user Id*/
	public UserVO getUserById(int userId);
	
	/** Lets the user login the application */
	public UserVO loginUser(String userName, String password) throws NoResultException;
	
	/** removes a user from the database */
	public void removeUser(UserVO user);
}
