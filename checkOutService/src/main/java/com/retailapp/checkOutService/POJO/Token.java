package com.retailapp.checkOutService.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="token")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderID;
	
	private String name;
	private String address;
	private String pinCode;
	private Integer userID;
	private String orderDate;
	private String orderTime;
	public Token() {
		super();
	}
	public Token(Integer orderID, String name, String address, String pinCode, Integer userID, String orderDate,
			String orderTime) {
		super();
		this.orderID = orderID;
		this.name = name;
		this.address = address;
		this.pinCode = pinCode;
		this.userID = userID;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	
	
	
}
