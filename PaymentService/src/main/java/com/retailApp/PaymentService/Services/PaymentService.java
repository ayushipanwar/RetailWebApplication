package com.retailApp.PaymentService.Services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface PaymentService {

	ResponseEntity<String> add(Map<String, String> requestMap);

}
