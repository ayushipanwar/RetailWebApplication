package com.retailapp.catalog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailapp.catalog.POJO.Category;

public interface CategoryDao extends JpaRepository<Category,Integer> {

}
