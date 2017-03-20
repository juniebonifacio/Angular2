package com.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.business.*;
import com.dao.ItemDao;
import com.domain.business.ItemBO;
import com.domain.hibernate.ItemVO;

public class ItemBusinessImpl extends BusinessType implements ItemBusiness {
	/** Item data access object*/
	private ItemDao itemDao;
	Logger log = Logger.getLogger(ItemBusinessImpl.class);

	@Override
	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public void addItem(ItemBO item) {
		if(null != item)
			itemDao.addItem(getMapper().map(item, ItemVO.class));
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public void updateItem(ItemBO item) {
		if(null != item)
			itemDao.updateItem(getMapper().map(item, ItemVO.class));
	}

	@Override
	@Transactional
	public List<ItemBO> getAllItems() {
		List<ItemBO> items = new ArrayList<ItemBO>();
		
		for(ItemVO itemVO : itemDao.getAllItems()){
			items.add(getMapper().map(itemVO, ItemBO.class));
		}
		return items;
	}

	@Override
	@Transactional
	public ItemBO getItemById(int itemId) {
		ItemVO itemVo = null;
		try{
			itemVo = itemDao.getItemById(itemId);
		}catch(NoResultException nre){
			log.warn("No item with id '" + itemId + "' is present in the database");
			return null;
		}
		
		return getMapper().map(itemVo, ItemBO.class);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public List<ItemBO> getItemsByUserId(int userId) {
		List<ItemBO> items = new ArrayList<ItemBO>();
		
		for(ItemVO itemVO : itemDao.getItemsByUserId(userId)){
			items.add(getMapper().map(itemVO, ItemBO.class));
		}
		return items;
	}

	/**
	 * @return the itemDao
	 */
	public ItemDao getItemDao() {
		return itemDao;
	}

	/**
	 * @param itemDao the itemDao to set
	 */
	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	

}
