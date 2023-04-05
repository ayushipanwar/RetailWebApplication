package com.retailApp.PaymentService.Rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path="/payment")
public interface PaymentRest {
	
	@PostMapping(path="/add")
	ResponseEntity<String>add(@RequestBody(required=true) Map<String,String>requestMap );

}
