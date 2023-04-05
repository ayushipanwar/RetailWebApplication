package com.retailapp.catalog.POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="category")
public class Category implements Serializable{
	private static final  long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="categoryId")
	private Integer categoryId;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="image")
	private String image;
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Category(Integer categoryId, String title, String image) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.image = image;
	}
	
	public Category()
	{
		
	}
	
	
}
