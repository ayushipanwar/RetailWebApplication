package com.retail.ProductService.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retail.ProductService.Categories.ProductWrapper;
import com.retail.ProductService.POJO.Product;



@RequestMapping(path="/product")
public interface ProductServiceRest {

@GetMapping(path="/view")
public ResponseEntity<List<Product>>viewAllProduct();

@GetMapping(path="/getById/{id}")
ResponseEntity<Optional<Product>>  findProductById(@PathVariable Integer id);

@GetMapping(path="/getByCategoryid/{category_id}")
ResponseEntity<List<ProductWrapper>>getByCategoryid(@PathVariable Integer category_id);

@GetMapping(path="/getByName/{name}")
ResponseEntity<ProductWrapper>getByName(@PathVariable String name);



}
