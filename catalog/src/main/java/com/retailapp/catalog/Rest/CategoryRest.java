package com.retailapp.catalog.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retailapp.catalog.POJO.Category;
import com.retailapp.catalog.Products.Products;

@RequestMapping(path="/category")
public interface CategoryRest {
	@GetMapping("/getCategories")
	public ResponseEntity<List<Category>>getAllCategory();
	
	@GetMapping("/getCategory/{id}")
	public ResponseEntity<Optional<Category>> getCateogory(@PathVariable Integer id);
	
	@GetMapping("/getCategoryProducts/{id}")
	public ResponseEntity<List<Products>>getCategoryProducts(@PathVariable Integer id);

}
