package com.retailapp.catalog.Products;

import java.util.List;

public class ProductList {
	List<Products>productsList;

	public List<Products> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Products> productsList) {
		this.productsList = productsList;
	}

	public ProductList(List<Products> productsList) {
		super();
		this.productsList = productsList;
	}

	public ProductList() {
		super();
	}

	@Override
	public String toString() {
		return "ProductList [productsList=" + productsList + ", getProductsList()=" + getProductsList() + "]";
	}
	
	
}
