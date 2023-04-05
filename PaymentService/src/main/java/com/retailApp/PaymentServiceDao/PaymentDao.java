package com.retailApp.PaymentServiceDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailApp.PaymentService.POJO.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer>{
	
}
