package com.domain.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "USER")
public class UserVO {

	@Id 
	@GeneratedValue
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_ROLE")
	private String role;
	
	@Column(name="USER_PASSWORD")
	private String password;
	
	@OneToMany(orphanRemoval=true, fetch=FetchType.LAZY, mappedBy="user")
	private List<ItemVO> items; 

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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	/**
	 * @return the items
	 */
	@JsonIgnore(value=true)
	public List<ItemVO> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<ItemVO> items) {
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder sBuilder = new StringBuilder("User ID: ").append(this.getId())
							   .append(" Name: ").append(this.getName())
							   .append(" role: ").append(this.getRole());
		return sBuilder.toString();
	}

}
