package com.retailApp.CartService.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//@NamedQuery(name="CartItem.deleteCartItem", query="Delete from CartItem c where c.userId =: userId and c.prod_id")
@NamedQuery(name = "CartItem.findByUserId", query ="select new com.retailApp.CartService.Pojo.CartItemWrapper(c.cartItemid,c.prod_id,c.prod_name,c.prod_price,c.prod_image,c.userId,c.prod_quantity,c.prod_desc) from CartItem c where c.userId =:userId")
@NamedQuery(name = "CartItem.findInCart", query ="select new com.retailApp.CartService.Pojo.CartItemWrapper(c.cartItemid,c.prod_id,c.prod_name,c.prod_price,c.prod_image,c.userId) from CartItem c where c.prod_id =:prod_id and c.userId=:userId")
//@NamedQuery(name = "CartItem.removeAllByUserId", query="Delete from CartItem c where c.userId =:userId")
@Entity
@Table(name = "cartItem")
public class CartItem {
	public String getProd_desc() {
		return prod_desc;
	}


	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cartItemid")
	private Integer cartItemid;
	
	 private Integer prod_id;

	 private String prod_name;

	  private Integer prod_price;

	  private String prod_image;
	  
	  private Integer prod_quantity;
	  private Integer userId;
	  
	  private String prod_desc;
	  

	public CartItem() {
		super();
	}
	

	public CartItem(Integer cartItemid, Integer prod_id, String prod_name, Integer prod_price, String prod_image,Integer userId,Integer prod_quantity,String prod_desc) {
		super();
		this.cartItemid = cartItemid;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_image = prod_image;
		this.userId = userId;
		this.prod_quantity = prod_quantity;
		this.prod_desc = prod_desc;
	}
	


	public CartItem(Integer prod_id, String prod_name, Integer prod_price, String prod_image, Integer userId,Integer prod_quantity) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_image = prod_image;
		this.userId = userId;
		this.prod_quantity= prod_quantity;
	}


	public Integer getProd_quantity() {
		return prod_quantity;
	}


	public void setProd_quantity(Integer prod_quantity) {
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

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
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
	  
	  
	  
}
