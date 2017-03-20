package com.domain.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ITEM")

public class ItemVO {
	
	/** item identifier*/
	@Id @GeneratedValue
	@Column(name = "ITEM_ID")
	private int id;
	
	/** User Id where this item belongs */
	@Column(name = "OWNER_ID")
	private int ownerId;
	
	/** Category Id where this item belongs */
	@Column(name = "CATEGORY_ID")
	private int categoryId;
		
	/** item name */
	@Column(name = "NAME")
	private String name;
	
	/** User story description */
	@Column(name = "DESCRIPTION")
	private String description;
	
	/** item price */
	@Column(name = "PRICE")
	private Double price;
	
	/** consumption date */
	@Column(name = "CONSUMPTION_DATE")
	private Date consumptionDate;
	
	/** expiry date */
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;
	
	/** is item available in personal inventory?*/
	@Column(name = "IS_AVAILABLE")
	private boolean isAvailable;
	
    @ManyToOne(optional=false, targetEntity=UserVO.class)
    @JoinColumn(name="OWNER_ID", referencedColumnName="USER_ID", insertable=false, updatable=false)
    @JsonBackReference
    private UserVO user;
    
    @ManyToOne(optional=false, targetEntity=CategoryVO.class)
    @JoinColumn(name="CATEGORY_ID", referencedColumnName="CAT_ID", insertable=false, updatable=false)
    @JsonBackReference
	private CategoryVO category; 
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ownerId
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the consumptionDate
	 */
	public Date getConsumptionDate() {
		return consumptionDate;
	}

	/**
	 * @param consumptionDate the consumptionDate to set
	 */
	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * @return the user
	 */
	public UserVO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserVO user) {
		this.user = user;
	}
	
	
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	/**
	 * @return the category
	 */
	public CategoryVO getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	@Override
	public String toString(){
		StringBuilder sBuilder = new StringBuilder("ID: ").append(this.getId())
							   .append(" Name: ").append(this.getName())
							   .append(" Owner: ").append(this.getOwnerId())
							   .append(" Category: ").append(this.getCategory().getName());
		return sBuilder.toString();
	}

}
