package com.retailapp.checkOutService.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface CheckoutService {

	ResponseEntity<String> checkOut(Map<String, String> requestMap);

}
