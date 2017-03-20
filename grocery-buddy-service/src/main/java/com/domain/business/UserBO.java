/**
 * Represents the business object for a user story
 */
package com.domain.business;

import java.util.List;

import com.domain.hibernate.UserVO;

/**
 * @author jay
 *
 */
public class UserBO extends UserVO implements Comparable<UserBO> {
	private List<ItemBO> itemsList;
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(UserBO that) {
		int ret = 0;
		
		if(this.getId() < that.getId())
			ret = 1;
		else 
			ret = 0;
	
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		UserBO that = (UserBO) obj;
		boolean retVal = false;
		
		if (this.getId() == that.getId()) {
			retVal = true;
		} else {
			retVal = false;
		}

		if (null != this.getName() && null != that.getName()
				&& this.getName().equals(that.getName())) {
			retVal = true;
		} else {
			retVal = false;
		}

		if (null != this.getRole() && null != that.getRole() && this.getRole().equals(that.getRole())) {
			retVal = true;
		} else {
			retVal = false;
		}

		return retVal;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		return this.getId() * 17;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder sBuilder = new StringBuilder("User ID: ").append(this.getId())
							   .append(" Name: ").append(this.getName())
							   .append(" Role: ").append(this.getRole());
		return sBuilder.toString();
	}

	/**
	 * @return the itemsList
	 */
	public List<ItemBO> getItemsList() {
		return itemsList;
	}

	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(List<ItemBO> itemsList) {
		this.itemsList = itemsList;
	}
	
	

}
