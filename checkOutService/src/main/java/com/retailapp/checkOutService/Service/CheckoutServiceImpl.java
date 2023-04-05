package com.retailapp.checkOutService.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retailapp.checkOutService.CheckoutDao.CheckoutServiceDao;
import com.retailapp.checkOutService.CheckoutDao.TokenDao;
import com.retailapp.checkOutService.POJO.CheckOut;
import com.retailapp.checkOutService.POJO.Token;
import com.retailapp.checkOutService.Wrapper.PaymentWrapper;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	TokenDao tokenDao;
	@Autowired
	CheckoutServiceDao checkOutDao;
	@Override
	
	public ResponseEntity<String> checkOut(Map<String, String> requestMap) {
		Integer totalAmount = 0;
		System.out.println("in The Checkout");
		try {
			System.out.println(requestMap);
		 Token token = new Token();
		 token.setUserID(Integer.parseInt(requestMap.get("userId")));
		 token.setName(requestMap.get("name"));
		 token.setAddress(requestMap.get("address"));
		 token.setPinCode(requestMap.get("pinCode"));
		 Date date = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		  String str = formatter.format(date);
		  token.setOrderDate(str);
		  
		    String strDateFormat = "hh:mm:ss a";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    String formattedDate= dateFormat.format(date);
		 token.setOrderTime(formattedDate);
		
		 tokenDao.save(token);
		 Integer userId1 = Integer.parseInt(requestMap.get("userId"));
		 System.out.println(requestMap);
		 ResponseEntity<ArrayList>response = restTemplate.getForEntity("http://localhost:8087/cart/getUserCart/" + userId1, ArrayList.class);
		
		 System.out.println(response);
		 ArrayList arr = response.getBody();
		//System.out.println(response.getBody().getClass().cast(System));
		 //System.out.println(response);
		 if(!Objects.isNull(response))
		 {
		
			
			 Integer orderId = token.getOrderID();
			 
			 for(int i = 0; i< arr.size(); i++)
			 { CheckOut checkOut = new CheckOut();
				 
				 Map<String,Object>req  = (Map<String, Object>) arr.get(i);
				// req.get("prod_id");
				 Integer p = (Integer) req.get("prod_id");
				 System.out.println(p);
				 //cartWrapper =(CartWrapper) cartItems.get(i);
				// int n =Integer.parseInt(req.get((Integer)("prod_id")));
				// System.out.println(req.containsKey("prod_name") +" "+ Integer.valueOf(req.get("prod_id")));;
		 checkOut.setOrderId(orderId);
		 checkOut.setUserId(userId1);
		 System.out.println("cartItems" + req.get("cartItemid"));
	 checkOut.setProd_Id((Integer) req.get("prod_id"));
	 totalAmount+=(Integer)req.get("prod_price");
		 checkOut.setQuantity((Integer) req.get("prod_quantity"));
			 checkOutDao.save(checkOut);
			 ResponseEntity<String>res = restTemplate.getForEntity("http://localhost:8087/cart/deleteCartItem/" + req.get("cartItemid"), String.class);
			
				
			 }
 PaymentWrapper paymentWrapper =new PaymentWrapper();
			 
			 paymentWrapper.setOrderId(orderId);
			 paymentWrapper.setAmount(totalAmount);
			 paymentWrapper.setDate(str);
			 paymentWrapper.setTime(formattedDate);
			 ResponseEntity<String>resp = restTemplate.postForEntity("http://localhost:9092/payment/add",paymentWrapper, String.class);
					
			
			 return new ResponseEntity<>("CheckedOut SucessFully",HttpStatus.OK);
			 
		 }
		 else
		 {
			 return new ResponseEntity<>("Something went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		 return new ResponseEntity<>("CheckedOut SucessFully",HttpStatus.OK);

	
	}
	
	
	

}
