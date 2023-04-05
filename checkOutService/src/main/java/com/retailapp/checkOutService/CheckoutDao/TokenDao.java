package com.retailapp.checkOutService.CheckoutDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailapp.checkOutService.POJO.Token;

public interface TokenDao extends JpaRepository<Token, Integer> {

}
