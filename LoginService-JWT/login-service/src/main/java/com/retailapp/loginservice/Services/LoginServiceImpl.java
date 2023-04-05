package com.retailapp.loginservice.Services;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.retailapp.loginservice.Dao.UserDao;
import com.retailapp.loginservice.JWT.CustomerUserDetailService;
import com.retailapp.loginservice.JWT.JwtFilter;
import com.retailapp.loginservice.JWT.JwtUtill;
import com.retailapp.loginservice.POJO.User;

@Service
public class LoginServiceImpl implements LoginService {
 
	@Autowired(required=true)
	UserDao loginDao;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomerUserDetailService customerUserDetailService;
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	JwtUtill jwtUtill;
	
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
	
	try
	{
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestMap.get("email"),requestMap.get("password")));
		
	if(auth.isAuthenticated())
	{
		return new ResponseEntity<String>("{\"token\":\""+ jwtUtill.generateToken(customerUserDetailService.getUserDetails().getEmail()) +"\"}",HttpStatus.OK);
				
	}
	else
	{
		return new ResponseEntity<String>("{\"message\":\""+"You are not authorized."+"\"}",HttpStatus.BAD_REQUEST);
	}
	
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return new ResponseEntity<String>("{\"message\":\""+"Something Went Wrong."+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);		
	}


}
