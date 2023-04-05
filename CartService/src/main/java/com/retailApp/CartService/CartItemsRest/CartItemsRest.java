package com.retailApp.CartService.CartItemsRest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;

import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(path="/cart")
public interface CartItemsRest {
	
	@PostMapping(path="/add")
	ResponseEntity<String>addToCart(@RequestBody(required=true) Map<String,String>requestMap);
	
	@GetMapping(path="/getAll")
	ResponseEntity<List<CartItem>>getAll();
	
	@GetMapping(path="/getUserCart/{userId}")
	ResponseEntity<List<CartItemWrapper>>getUserCart(@PathVariable Integer userId);
	
	@GetMapping(path="/deleteCartItem/{id}")
	ResponseEntity<String>deleteCartItem(@PathVariable Integer id);
	
//	@GetMapping(path="/deleteAllByUserId/{userId}")
//	ResponseEntity<String>deleteAllByUserId(@PathVariable Integer userId);

}
