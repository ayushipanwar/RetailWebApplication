package com.retailapp.checkOutService.Wrapper;

public class CartWrapper {
	private Integer cartItemid;
	
	 private Integer prod_id;

	 private String prod_name;

	  private Integer prod_price;

	  private String prod_image;
	  private String prod_desc;
	  
	  private Integer userId;
	  private Integer prod_quantity;
	  

	public CartWrapper() {
		super();
	}


	public CartWrapper(Integer cartItemid, Integer prod_id, String prod_name, Integer prod_price, String prod_image,
			String prod_desc, Integer userId, Integer prod_quantity) {
		super();
		this.cartItemid = cartItemid;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_image = prod_image;
		this.prod_desc = prod_desc;
		this.userId = userId;
		this.prod_quantity = prod_quantity;
	}


	public Integer getCartItemid() {
		return cartItemid;
	}


	public void setCartItemid(Integer cartItemid) {
		this.cartItemid = cartItemid;
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


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getProd_quantity() {
		return prod_quantity;
	}


	public void setProd_quantity(Integer prod_quantity) {
		this.prod_quantity = prod_quantity;
	}

		  
}
