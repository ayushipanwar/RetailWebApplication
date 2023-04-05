package com.retailApp.CartService.Pojo;

import java.util.List;

public class ListCart {
public List< CartItemWrapper>listCart;






public ListCart() {
	super();
}

public List<CartItemWrapper> getListCart() {
	return listCart;
}

public void setListCart(List<CartItemWrapper> listCart) {
	this.listCart = listCart;
}

public ListCart(List<CartItemWrapper> listCart) {
	super();
	this.listCart = listCart;
}





}
