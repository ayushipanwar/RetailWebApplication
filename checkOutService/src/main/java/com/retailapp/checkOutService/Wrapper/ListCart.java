package com.retailapp.checkOutService.Wrapper;

import java.util.List;

public class ListCart {

	private List<CartWrapper> listOfCart;

	
	
	public ListCart() {
		super();
	}

	public ListCart(List<CartWrapper> listOfCart) {
		super();
		this.listOfCart = listOfCart;
	}

	public List<CartWrapper> getListOfCart() {
		return listOfCart;
	}

	public void setListOfCart(List<CartWrapper> listOfCart) {
		this.listOfCart = listOfCart;
	}

	@Override
	public String toString() {
		return "ListCart [listOfCart=" + listOfCart + ", getListOfCart()=" + getListOfCart() + "]";
	}
	
	
	
	
	
}
