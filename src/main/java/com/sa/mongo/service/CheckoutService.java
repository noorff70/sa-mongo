package com.sa.mongo.service;

import org.springframework.http.ResponseEntity;

import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.model.CreditCardRequestObject;
import com.stripe.model.Charge;

public interface CheckoutService {
	
	public ResponseEntity<?> checkout (CreditCardRequestObject creditCardRequestObj);

}
