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

import com.business.ItemBusiness;
import com.domain.business.ItemBO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:business/business-config.xml"})
public class ItemDataQueryTest {
	
	private ItemBusiness itemBusinessFacade;
	private static Log log = LogFactory.getLog(ItemDataQueryTest.class);
	
	@Test
	public void itemDataQueryTest(){
		//testFindItemsByUserById(0);
		//testFindItemsByUserById(3);
		//testFindItemById(3);
		testAddItem(1, "Corned Beef", 0);
		findAllItems();
	}
	
	public void testAddItem(int ownerId, String name, int categoryId){
		ItemBO item = new ItemBO();
		
		item.setOwnerId(ownerId);
		item.setName(name);
		item.setCategoryId(categoryId);
		
		itemBusinessFacade.addItem(item);
	}
	
	public void findAllItems(){
		
		List<ItemBO> itemList = itemBusinessFacade.getAllItems();
		log.info("DISPLAYING ALL ITEMS from the DB");
		
		for(ItemBO item : itemList){
			log.info(item);
		}
		
	}
	
	public void testFindItemsByUserById(int id){
		List<ItemBO> items = null;
		
		items = itemBusinessFacade.getItemsByUserId(id);
		
		for(ItemBO item : items){
			log.info(item);
		}
	}
	
	public void testFindItemById(int itemId){
		ItemBO item = itemBusinessFacade.getItemById(itemId);
		Assert.assertTrue(null != item);
		log.info(item);
	}

	/**
	 * @return the itemBusinessFacade
	 */
	public ItemBusiness getItemBusinessFacade() {
		return itemBusinessFacade;
	}

	/**
	 * @param itemBusinessFacade the itemBusinessFacade to set
	 */
	@Autowired
	public void setItemBusinessFacade(ItemBusiness itemBusinessFacade) {
		this.itemBusinessFacade = itemBusinessFacade;
	}
	

	
}
