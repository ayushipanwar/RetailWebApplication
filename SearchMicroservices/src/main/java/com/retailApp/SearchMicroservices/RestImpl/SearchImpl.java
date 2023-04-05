package com.retailApp.SearchMicroservices.RestImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.retailApp.SearchMicroservices.Rest.Searchrest;
import com.retailApp.SearchMicroservices.Service.SearchService;
import com.retailApp.SearchMicroservices.Wrapper.ProductWrapper;

@RestController
public class SearchImpl implements Searchrest {

	@Autowired
	SearchService searchService;
	
	@Override
	public ResponseEntity<List<ProductWrapper>> searchProductByName(String name) {
		return searchService.searchProductByName(name);
	}

}
