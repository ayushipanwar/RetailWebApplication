package com.retailapp.catalog.RestImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.retailapp.catalog.POJO.Category;
import com.retailapp.catalog.Products.Products;
import com.retailapp.catalog.Rest.CategoryRest;
import com.retailapp.catalog.Services.CategoryService;

@RestController
public class CategoryRestImpl implements CategoryRest {

	@Autowired
	CategoryService categoryService;
	@Override
	public ResponseEntity<List<Category>> getAllCategory() {
		return categoryService.getAllCategory();
	}
	@Override
	public ResponseEntity<Optional<Category>> getCateogory(Integer id) {
		return categoryService.getCategory(id);
	}
	@Override
	public ResponseEntity<List<Products>> getCategoryProducts(Integer id) {
		 return categoryService.getCategoryProducts(id);
	}

}
