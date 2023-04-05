package com.retailapp.checkOutService.CheckoutDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailapp.checkOutService.POJO.CheckOut;


public interface CheckoutServiceDao extends JpaRepository<CheckOut,Integer>{

}
