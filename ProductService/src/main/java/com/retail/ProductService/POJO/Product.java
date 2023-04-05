package com.retail.ProductService.POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

//@NamedQuery(name = "Product.findAllByName", query="select new com.retail.ProductService.Categories.ProductWrapper(p.prod_id,p.prod_name,p.prod_price,p.prod_image,p.prod_desc,p.stock) from Product p where like 'a'" )
@NamedQuery(name = "Product.findAllBycategory_id", query="select new com.retail.ProductService.Categories.ProductWrapper(p.prod_id,p.prod_name,p.prod_price,p.prod_image,p.prod_desc,p.stock) from Product p where p.category_id =:category_id" )
@Entity
@Table(name ="product")
public class Product implements Serializable {
	
	private static final  long serialVersionUID = 1L;
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name = "prod_id")
private Integer prod_id;

@Column(name = "prod_name")
private String prod_name;

@Column(name="prod_price")
private Integer prod_price;

@Column(name="prod_image")
private String prod_image;

@Column(name="prod_desc")
private String prod_desc;

@Column(name="stock")
private Boolean stock;

@Column(name="category_id")
private Integer category_id;

public Product()
{
	
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

public Product(Integer prod_id, String prod_name, Integer prod_price, String prod_image, String prod_desc,
		Boolean stock) {
	super();
	this.prod_id = prod_id;
	this.prod_name = prod_name;
	this.prod_price = prod_price;
	this.prod_image = prod_image;
	this.prod_desc = prod_desc;
	this.stock = stock;
}

@Override
public String toString() {
	return "Product [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_price=" + prod_price + ", prod_image="
			+ prod_image + ", prod_desc=" + prod_desc + ", stock=" + stock + ", category_id=" + category_id
			+ ", getProd_id()=" + getProd_id() + ", getProd_name()=" + getProd_name() + ", getProd_price()="
			+ getProd_price() + ", getProd_image()=" + getProd_image() + ", getProd_desc()=" + getProd_desc()
			+ ", getStock()=" + getStock() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}




}
