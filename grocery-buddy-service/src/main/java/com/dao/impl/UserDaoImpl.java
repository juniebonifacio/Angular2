package com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.domain.hibernate.UserVO;

@Repository
public class UserDaoImpl implements UserDao{
	
    @PersistenceContext    
    private EntityManager entityManager;
    Logger log = Logger.getLogger(UserDaoImpl.class);
    
    public UserDaoImpl(){}
    
    public UserDaoImpl(EntityManagerFactory entityManagerFactory){
    	entityManager = entityManagerFactory.createEntityManager();
    }

	@Override
	public void addUser(UserVO user) {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(UserVO user) {
		entityManager.merge(user);
		
	}
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT)
	public List<UserVO> getAllUsers() {
		return entityManager.createQuery("FROM UserVO").getResultList();
	}

	@Override
	public UserVO getUserById(int userId) {		
		Query query = entityManager.createNamedQuery("getUserById");
		query.setParameter("userId", userId);
		
		return (UserVO)query.getSingleResult();
	}

	@Override
	public UserVO loginUser(String userName, String password) throws NoResultException{
		Query query = entityManager.createNamedQuery("loginUser");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		
		return (UserVO)query.getSingleResult();
	}

	@Override
	public void removeUser(UserVO user) {
		entityManager.remove(user);		
	}

}
