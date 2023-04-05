package com.retailapp.checkOutService.Wrapper;



public class PaymentWrapper {

	
	private Integer Amount;
	
	private Integer orderId;
	
	private String date;
	private String time;
	public PaymentWrapper() {
		super();
	}
	public PaymentWrapper(Integer amount, Integer orderId, String date, String time) {
		super();
		
		Amount = amount;
		this.orderId = orderId;
		this.date = date;
		this.time = time;
	}

	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
}
