package com.retail.ProductService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.retail.ProductService.Categories.ProductWrapper;
import com.retail.ProductService.POJO.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{

	List<ProductWrapper> findAllBycategory_id(Integer category_id);
	
	//List<ProductWrapper> findAllByName(String name);

	//Product getProductById(@Param("id")Integer id);
}
