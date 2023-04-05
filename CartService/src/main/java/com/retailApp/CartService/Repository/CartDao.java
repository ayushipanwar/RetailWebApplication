package com.retailApp.CartService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;


public interface CartDao extends JpaRepository<CartItem,Integer> {

	//CartItemWrapper findByProd_id(int id);

	List<CartItemWrapper> findByUserId(Integer userId);

	CartItemWrapper findInCart(Integer prod_id, Integer userId);

	//ResponseEntity<String> removeAllByUserId(Integer userId);

//	void deleteCartItem(Integer userId, Integer prod_id);

}
