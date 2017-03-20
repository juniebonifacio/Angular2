/**
 * 
 */
package com.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.business.*;
import com.dao.UserDao;
import com.domain.business.UserBO;
import com.domain.hibernate.UserVO;

/**
 * @author jay
 *
 */
@Component
public class UserBusinessImpl extends BusinessType implements UserBusiness {
	Logger log = Logger.getLogger(UserBusinessImpl.class);
	
	/** User data access object */ 
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.business.UserBusiness#addUser(com.domain.business.UserBO)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void addUser(UserBO user) {
		if(null != user)
			userDao.addUser(getMapper().map(user, UserVO.class));
	}

	/* (non-Javadoc)
	 * @see com.business.UserBusiness#updateUser(com.domain.business.UserBO)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public void updateUser(UserBO user) {
		if(null != user)
			userDao.updateUser(getMapper().map(user, UserVO.class));
	}

	/* (non-Javadoc)
	 * @see com.business.UserBusiness#getAllUsers()
	 */
	@Override
	@Transactional
	public List<UserBO> getAllUsers() {
		
		UserBO userBO = null;
		List<UserBO> userList = new ArrayList<UserBO>();
		
		for(UserVO userVO : userDao.getAllUsers()){
			userBO = getMapper().map(userVO, UserBO.class);
			userList.add(userBO);
		}
		
		return userList;
	}
	
	/* (non-Javadoc)
	 * @see com.business.UserStoryBusiness#getUserStory()
	 */
	@Override
	@Transactional
	public UserBO getUserById(int userId) {
		return getMapper().map(userDao.getUserById(userId), UserBO.class);
	}

	@Override
	@Transactional
	public UserBO loginUser(String userName, String password) {
		UserVO userVo = null;
		try{
			userVo = userDao.loginUser(userName, password);
		}catch(NoResultException nre){
			log.info("User '" + userName + "' failed to logged in.");
			return null;
		}
		
		UserBO user = getMapper().map(userVo, UserBO.class);
		log.info("User '" + user.getName() + "' has successfully logged in.");
		
		return user;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void removeUser(int userId) {
		try{
			UserBO user = getMapper().map(userDao.getUserById(userId), UserBO.class);
			userDao.removeUser(user);
			log.info("Successfully removed the user");
		}catch(NullPointerException npe){
			log.error("User to be removed did not exist!");
		}catch(Exception e){
			log.error("Failed to remove user!");
			throw e;
		}
	}

	/**
	 * @return the userDao
	 */
	public UserDao getuserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	@Autowired
	public void setuserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
