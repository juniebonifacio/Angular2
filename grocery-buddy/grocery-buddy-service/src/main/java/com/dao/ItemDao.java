package com.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.domain.hibernate.ItemVO;

public interface ItemDao {
	/**Insert an item*/
	public void addItem(ItemVO item);
	
	/**Update an item*/
	public void updateItem(ItemVO item);
	
	/**Gets all items from the database*/
	public List<ItemVO> getAllItems(); 
	
	/**Gets an items given the item Id*/
	public ItemVO getItemById(int itemId) throws NoResultException;
	
	/**Gets all items associated to a user given the userId*/
	public List<ItemVO> getItemsByUserId(int userId) throws NoResultException;

}
