package com.business;

import java.util.List;

import com.domain.business.ItemBO;

public interface ItemBusiness {
	/**Insert an item*/
	public void addItem(ItemBO item);
	
	/**Update an item*/
	public void updateItem(ItemBO item);
	
	/**Gets all items from the database*/
	public List<ItemBO> getAllItems(); 
	
	/**Gets an items given the item Id*/
	public ItemBO getItemById(int itemId);
	
	/**Gets all items associated to a user given the userId*/
	public List<ItemBO> getItemsByUserId(int userId);
}
