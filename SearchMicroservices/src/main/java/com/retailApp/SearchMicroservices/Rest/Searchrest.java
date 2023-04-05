package com.retailApp.SearchMicroservices.Rest;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retailApp.SearchMicroservices.Wrapper.ProductWrapper;

@RequestMapping(path="/product")
public interface Searchrest {

	@GetMapping(path="/search/{name}")
	ResponseEntity<List<ProductWrapper>> searchProductByName(@PathVariable String name);
}
