/**
 * Represents the business object for an item
 */
package com.domain.business;

import com.domain.hibernate.ItemVO;

/**
 * @author jay
 *
 */
public class ItemBO extends ItemVO implements Comparable<ItemBO> {
	
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ItemBO that) {
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
		ItemBO that = (ItemBO) obj;
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
		StringBuilder sBuilder = new StringBuilder("\n\t\t Owner: ").append(getUser().getName())
							   .append("\n\t\t Item: ").append(getName())
							   .append("\n\t\t Category: ").append(getCategory().getName());
		return sBuilder.toString();
	}

}
