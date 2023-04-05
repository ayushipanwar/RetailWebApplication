package com.retailapp.loginservice.Restimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.retailapp.loginservice.Rest.UserLoginRest;
import com.retailapp.loginservice.Services.LoginService;

@RestController
public class UserLoginRestImpl implements UserLoginRest {

	@Autowired
	LoginService loginService;
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		
		try {
			return loginService.login(requestMap);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity(" ", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
