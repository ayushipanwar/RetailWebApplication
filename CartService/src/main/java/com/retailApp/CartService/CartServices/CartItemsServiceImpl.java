package com.retailApp.CartService.CartServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;
import com.retailApp.CartService.Repository.CartDao;

@Service
public class CartItemsServiceImpl implements CartItemsService {

	@Autowired
	CartDao cartDao;
	@Override
	public ResponseEntity<String> addToCart(Map<String,String>requestMap) {
		System.out.println(requestMap);
		CartItemWrapper cart= cartDao.findInCart(Integer.parseInt(requestMap.get("prod_id")),Integer.parseInt(requestMap.get("userId")));
		if(Objects.isNull(cart))
		{
			System.out.println(requestMap.get("prod_name"));
			System.out.println(Integer.parseInt(requestMap.get("userId")));
			System.out.println(requestMap.get("prod_quantity"));
		CartItem cartItem = new CartItem();
		try {
		cartItem.setProd_id(Integer.parseInt(requestMap.get("prod_id")));
		cartItem.setProd_name(requestMap.get("prod_name"));
		cartItem.setProd_image(requestMap.get("prod_image"));
		cartItem.setProd_price(Integer.parseInt(requestMap.get("prod_price")));
		cartItem.setUserId(Integer.parseInt(requestMap.get("userId")));
		cartItem.setProd_quantity(Integer.parseInt(requestMap.get("prod_quantity")));
		cartItem.setProd_desc(requestMap.get("prod_desc"));
		
		cartDao.save(cartItem);
		return new ResponseEntity<String>("Item Added",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return new ResponseEntity<String>("Item Not Added",HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		else
		{
			return new ResponseEntity<String>("Item Already In Cart",HttpStatus.BAD_REQUEST);
		}
		
	}
	@Override
	public ResponseEntity<List<CartItem>> getAll() {
		List<CartItem>cartItems = new ArrayList<>();
		cartItems = cartDao.findAll();
		
		if(!Objects.isNull(cartItems))
		{
			return new ResponseEntity<List<CartItem>>(cartItems,HttpStatus.OK);
		}
		
	  return new ResponseEntity<List<CartItem>>(cartItems,HttpStatus.NO_CONTENT);
	}
	@Override
	public ResponseEntity<List<CartItemWrapper>> getUserCart(Integer userId) {
		List<CartItemWrapper>cartItems = new ArrayList<>();
		cartItems=cartDao.findByUserId(userId);
		
		 return new ResponseEntity<List<CartItemWrapper>>(cartItems,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<String> deleteCartItem(Integer id) {
		Optional cartItem = cartDao.findById(id);
		if(!Objects.isNull(cartItem))
		{
			cartDao.deleteById(id);
			return new ResponseEntity<String>("item Deleted Sucessfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("item Not Present",HttpStatus.BAD_REQUEST);
		}
		
		
	}
//	@Override
//	public ResponseEntity<String> deleteAllByUserId(Integer userId) {
//		return cartDao.removeAllByUserId(userId);
//	}
	
	

}