package com.retailApp.PaymentService.Services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retailApp.PaymentService.POJO.Payment;
import com.retailApp.PaymentService.PaymentServiceDao.PaymentDao;


@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<String> add(Map<String, String> requestMap) {
		try {
			
			
			Payment payment = new Payment();
			payment.setOrderId(Integer.parseInt(requestMap.get("orderId")));
			payment.setAmount(Integer.parseInt(requestMap.get("amount")));
			payment.setDate(requestMap.get("date"));
			payment.setTime(requestMap.get("time"));
			paymentDao.save(payment);
			return new ResponseEntity<String>("Payment Done",HttpStatus.OK);
		}
		catch(Exception ex)
		{
		ex.printStackTrace();	
		}
		return new ResponseEntity<String>("Payment Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
