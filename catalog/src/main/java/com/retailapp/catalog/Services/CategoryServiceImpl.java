package com.retailapp.catalog.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retailapp.catalog.Dao.CategoryDao;
import com.retailapp.catalog.POJO.Category;
import com.retailapp.catalog.Products.ProductList;
import com.retailapp.catalog.Products.Products;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CategoryDao categoryDao;
	@Override
	public ResponseEntity<List<Category>> getAllCategory() {
		try {
			List<Category> categories = categoryDao.findAll();
			return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<Optional<Category>> getCategory(Integer id) {
		try {
			@SuppressWarnings("deprecation")
			Optional<Category> category = categoryDao.findById(id);
			return new ResponseEntity<Optional<Category>>(category,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
@Override
	public ResponseEntity<List<Products>>getCategoryProducts(Integer id) {
		try {
			ResponseEntity<ArrayList>responseEntity = restTemplate.getForEntity("http://localhost:8084/product/getByCategoryid/" + id, ArrayList.class);
		//	ProductList productList = responseEntity.getBody();
			
			System.out.println(responseEntity);
			ArrayList productList = responseEntity.getBody(); 
			System.out.println(productList);
			
			//List<Products>productList= getProductFromList(productList);
			
			
			return new ResponseEntity<List<Products>>(productList, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<List<Products>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
//private List<Products> getProductFromList(ArrayList productList) {
//	
//	List<Products>ext = new ArrayList();
//	
//	for(int i =0; i< productList.size(); i++)
//	{
//		Products products;
//		products.setProd_id(productList(i).getid);
//	}
//}
public CategoryServiceImpl(CategoryDao categoryDao) {
	super();
	this.categoryDao = categoryDao;
}



}
