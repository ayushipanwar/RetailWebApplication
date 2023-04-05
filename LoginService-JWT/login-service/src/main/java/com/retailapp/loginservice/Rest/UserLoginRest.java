package com.retailapp.loginservice.Rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path="/user")
public interface UserLoginRest {

	
	@PostMapping(path = "/login")
	public ResponseEntity<String>login(@RequestBody(required = true) Map<String,String>requestMap);
}
