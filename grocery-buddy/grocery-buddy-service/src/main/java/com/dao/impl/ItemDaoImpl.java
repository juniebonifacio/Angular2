package com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.ItemDao;
import com.domain.hibernate.ItemVO;

public class ItemDaoImpl implements ItemDao {
    @PersistenceContext    
    private EntityManager entityManager;
    
    /** Generic Constructor*/
    public ItemDaoImpl(){}
    
    public ItemDaoImpl(EntityManagerFactory entityManagerFactory){
    	entityManager = entityManagerFactory.createEntityManager();
    }

	@Override
	public void addItem(ItemVO item) {
		entityManager.persist(item);

	}

	@Override
	public void updateItem(ItemVO item) {
		entityManager.merge(item);
	}

	@Override
	public List<ItemVO> getAllItems() {
		return entityManager.createQuery("FROM ItemVO").getResultList();
	}

	@Override
	public ItemVO getItemById(int itemId) throws NoResultException{
		Query query = entityManager.createNamedQuery("getItemById");
		query.setParameter("itemId", itemId);
		
		return (ItemVO)query.getSingleResult();
	}

	@Override
	public List<ItemVO> getItemsByUserId(int userId)throws NoResultException {
		Query query = entityManager.createNamedQuery("getItemsByUserId");
		query.setParameter("userId", userId);
		
		return query.getResultList();
	}

}
