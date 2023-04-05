package com.retailApp.CartService.CartItemsRestImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.retailApp.CartService.CartItemsRest.CartItemsRest;
import com.retailApp.CartService.CartServices.CartItemsService;
import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;

@RestController
public class CartItemsRestImpl implements CartItemsRest {
	
	@Autowired
	CartItemsService cartItemsService;
	
	@Override
	public ResponseEntity<String> addToCart(Map<String, String> requestMap) {
		return cartItemsService.addToCart(requestMap);
	}

	@Override
	public ResponseEntity<List<CartItem>> getAll() {
		return cartItemsService.getAll();
	}

	@Override
	public ResponseEntity<List<CartItemWrapper>> getUserCart(Integer userId) {
		return cartItemsService.getUserCart(userId);
	}

	@Override
	public ResponseEntity<String> deleteCartItem(Integer id) {
	return cartItemsService.deleteCartItem(id);
	}

//	@Override
//	public ResponseEntity<String> deleteAllByUserId(Integer userId) {
//		// TODO Auto-generated method stub
//		return cartItemsService.deleteAllByUserId(userId);
//	}
//	
	

}
