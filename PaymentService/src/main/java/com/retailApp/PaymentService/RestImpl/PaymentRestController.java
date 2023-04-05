package com.retailApp.PaymentService.RestImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.retailApp.PaymentService.Rest.PaymentRest;
import com.retailApp.PaymentService.Services.PaymentService;

@RestController
public class PaymentRestController implements PaymentRest {

	@Autowired
	PaymentService paymentService;
	
	@Override
	public ResponseEntity<String> add(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		return paymentService.add(requestMap);
	}

}
