package com.sa.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sa.mongo.model.CreditCardRequestObject;
import com.sa.mongo.service.CheckoutService;

@RestController
public class CheckoutController {
	
	@Autowired
	CheckoutService checkoutService;

	
	@PostMapping("/mongo/creditcard/checkout")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> checkout(@RequestBody CreditCardRequestObject creditCardObject) {
		
		ResponseEntity resp = checkoutService.checkout(creditCardObject);
				
		return resp;
	}

}
