package com.business;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

public class BusinessType {
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

	/**
	 * @return the mapper
	 */
	public Mapper getMapper() {
		return mapper;
	}


}
