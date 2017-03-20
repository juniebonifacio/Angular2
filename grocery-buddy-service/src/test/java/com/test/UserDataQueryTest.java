package com.test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.business.UserBusiness;
import com.domain.business.ItemBO;
import com.domain.business.UserBO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:business/business-config.xml"})
public class UserDataQueryTest {
	
	private UserBusiness userBusinessFacade;
	private static Log log = LogFactory.getLog(UserDataQueryTest.class);
	
	@Test
	public void userDataQueryTest(){
		//loginUser();
		//loginUserInvalid();
		//testFindUserById(3);
		addUser();
		findAllUsers();
	}
	
	public void loginUser(){
		String userName = "Amiya";
		String password = "Passw0rd";
		
		Assert.assertTrue(null != userBusinessFacade.loginUser(userName, password));
	}
	
	public void loginUserInvalid(){
		String userName = "Amiya";
		String password = "Passw01rd";
		
		Assert.assertTrue(null == userBusinessFacade.loginUser(userName, password));
	}
	
	public void findAllUsers(){
		List<UserBO> userList = userBusinessFacade.getAllUsers();
		log.info("DISPLAY ALL USERS from the DB");
		
		for(UserBO user : userList){
			log.info(user);
			displayUserItems(user);
		}
		
	}
	
	public void addUser(){		
		UserBO user = new UserBO();
		user.setName("Eda");
		user.setPassword("1sdaan");
		
		userBusinessFacade.addUser(user);
	}
	
	public void displayUserItems(UserBO user){
		log.info(">>>>> Displaying " + user.getName() + "'s items <<<<<");
		for(ItemBO item : user.getItemsList()){
			log.info(item);
		}
	}
	
	public void testFindUserById(int id){		
		UserBO user = userBusinessFacade.getUserById(id);
		log.info(user);
	}
	
	/**
	 * @return the userStoryBusinessFacade
	 */
	public UserBusiness getUserStoryBusinessFacade() {
		return userBusinessFacade;
	}

	/**
	 * @param userStoryBusinessFacade the userStoryBusinessFacade to set
	 */
	@Autowired
	public void setUserBusinessFacade(UserBusiness userBusinessFacade) {
		this.userBusinessFacade = userBusinessFacade;
	}

	
}
