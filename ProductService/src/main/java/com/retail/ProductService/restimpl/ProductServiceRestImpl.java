package com.retail.ProductService.restimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ProductService.Categories.ProductWrapper;
import com.retail.ProductService.POJO.Product;
import com.retail.ProductService.rest.ProductServiceRest;
import com.retail.ProductService.services.ProductServices;

@RestController
public class ProductServiceRestImpl implements ProductServiceRest{

	@Autowired
	ProductServices productService;

	@Override
	public ResponseEntity<List<Product>> viewAllProduct() {
		try {
			return productService.viewAllProduct();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Optional<Product>> findProductById(Integer id) {
		try {
			System.out.println("In product id");
			return productService.findProductById(id);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity(new Product(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<ProductWrapper>> getByCategoryid(Integer category_id) {
		return productService.getByCategoryid(category_id);
	}

	@Override
	public ResponseEntity<ProductWrapper> getByName(String name) {
		// TODO Auto-generated method stub
		return productService.getByName(name);
	}


}
