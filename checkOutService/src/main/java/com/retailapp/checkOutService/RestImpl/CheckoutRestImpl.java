package com.retailapp.checkOutService.RestImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.retailapp.checkOutService.Rest.CheckoutRest;
import com.retailapp.checkOutService.Service.CheckoutService;

@RestController
public class CheckoutRestImpl implements CheckoutRest {
@Autowired
CheckoutService checkOutService;
	
	@Override
	public ResponseEntity<String> checkout(Map<String, String> requestMap) {
	return checkOutService.checkOut(requestMap);
	}

}
