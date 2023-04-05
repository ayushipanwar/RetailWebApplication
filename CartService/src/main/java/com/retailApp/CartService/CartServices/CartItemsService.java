package com.retailApp.CartService.CartServices;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;

public interface CartItemsService {

	ResponseEntity<String> addToCart(Map<String, String> requestMap);

	ResponseEntity<List<CartItem>> getAll();

	ResponseEntity<List<CartItemWrapper>> getUserCart(Integer userId);

	ResponseEntity<String> deleteCartItem(Integer id);

//	ResponseEntity<String> deleteAllByUserId(Integer userId);

}
