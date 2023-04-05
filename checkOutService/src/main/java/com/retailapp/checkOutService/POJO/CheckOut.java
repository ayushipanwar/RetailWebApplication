package com.retailapp.checkOutService.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkOut")
public class CheckOut {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItem;
	
	private Integer prod_Id;
	
	private Integer quantity;
	
	private Integer orderId;
	
	private Integer userId;

	public CheckOut() {
		super();
	}

	public CheckOut(Integer orderItem, Integer prod_Id, Integer quantity, Integer orderId, Integer userId) {
		super();
		this.orderItem = orderItem;
		this.prod_Id = prod_Id;
		this.quantity = quantity;
		this.orderId = orderId;
		this.userId = userId;
	}

	public Integer getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Integer orderItem) {
		this.orderItem = orderItem;
	}

	public Integer getProd_Id() {
		return prod_Id;
	}

	public void setProd_Id(Integer prod_Id) {
		this.prod_Id = prod_Id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

	

	

}
