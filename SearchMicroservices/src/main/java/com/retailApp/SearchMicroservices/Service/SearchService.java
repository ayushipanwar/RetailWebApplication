package com.retailApp.SearchMicroservices.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.retailApp.SearchMicroservices.Wrapper.ProductWrapper;

public interface SearchService {

	ResponseEntity<List<ProductWrapper>> searchProductByName(String name);

}
