package com.retailApp.SearchMicroservices.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retailApp.SearchMicroservices.Wrapper.ProductWrapper;


@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<List<ProductWrapper>> searchProductByName(String name) {
		try {
			System.out.println("Inside serach");
			ResponseEntity<ProductWrapper>responseEntity = restTemplate.getForEntity("http://localhost:8084/product/getByName/" + name, ProductWrapper.class);
		//	ProductList productList = responseEntity.getBody();
			
			System.out.println(responseEntity);
			ProductWrapper products = responseEntity.getBody(); 
			System.out.println(products);
			
			//List<Products>productList= getProductFromList(productList);
			List<ProductWrapper>productList = new ArrayList<ProductWrapper>();
			
			productList.add(products);
			return new ResponseEntity<List<ProductWrapper>>(productList, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<List<ProductWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
