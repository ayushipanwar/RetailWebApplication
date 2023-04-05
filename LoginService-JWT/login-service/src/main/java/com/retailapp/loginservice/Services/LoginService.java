package com.retailapp.loginservice.Services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface LoginService {

	ResponseEntity<String> login(Map<String, String> requestMap);

}
