package com.retailapp.checkOutService.Rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path="/checkout")
public interface CheckoutRest {
	
	@PostMapping(path="/add")
	ResponseEntity<String>checkout(@RequestBody(required = true) Map<String,String>requestMap);

}
