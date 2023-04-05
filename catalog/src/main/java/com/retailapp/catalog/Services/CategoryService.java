package com.retailapp.catalog.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.retailapp.catalog.POJO.Category;
import com.retailapp.catalog.Products.Products;

public interface CategoryService {

	ResponseEntity<List<Category>> getAllCategory();

	ResponseEntity<Optional<Category>> getCategory(Integer id);

	ResponseEntity<List<Products>> getCategoryProducts(Integer id);

}
