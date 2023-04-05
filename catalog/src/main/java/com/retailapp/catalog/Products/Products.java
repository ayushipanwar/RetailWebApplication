package com.retailapp.catalog.Products;



public class Products {
	private Integer prod_id;

	private String prod_name;

	private Integer prod_price;

	private String prod_image;

	private String prod_desc;

	private Boolean stock;

	public Products() {
		super();
	}

	public Products(Integer prod_id, String prod_name, Integer prod_price, String prod_image, String prod_desc,
			Boolean stock) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_image = prod_image;
		this.prod_desc = prod_desc;
		this.stock = stock;
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

	public String getProd_image() {
		return prod_image;
	}

	public void setProd_image(String prod_image) {
		this.prod_image = prod_image;
	}

	public String getProd_desc() {
		return prod_desc;
	}

	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}

	public Boolean getStock() {
		return stock;
	}

	public void setStock(Boolean stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Products [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_price=" + prod_price
				+ ", prod_image=" + prod_image + ", prod_desc=" + prod_desc + ", stock=" + stock + ", getProd_id()="
				+ getProd_id() + ", getProd_name()=" + getProd_name() + ", getProd_price()=" + getProd_price()
				+ ", getProd_image()=" + getProd_image() + ", getProd_desc()=" + getProd_desc() + ", getStock()="
				+ getStock() + "]";
	}

	
	
}
