package com.retailapp.checkOutService.Wrapper;

public class ProductWrapper {
	private Integer prod_id;
	
	private String prod_name;
	
	private Integer prod_price;
	
	private Integer prod_image;
	
	private Integer prod_quantity;

	public ProductWrapper() {
		super();
	}

	public ProductWrapper(Integer prod_id, String prod_name, Integer prod_price, Integer prod_image,
			Integer prod_quantity) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_image = prod_image;
		this.prod_quantity = prod_quantity;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public Integer getProd_price() {
		return prod_price;
	}

	public void setProd_price(Integer prod_price) {
		this.prod_price = prod_price;
	}

	public Integer getProd_image() {
		return prod_image;
	}

	public void setProd_image(Integer prod_image) {
		this.prod_image = prod_image;
	}

	public Integer getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(Integer prod_quantity) {
		this.prod_quantity = prod_quantity;
	}
	
	 

}
