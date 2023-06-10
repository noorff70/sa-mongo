package com.sa.mongo.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.model.CreditCardRequestObject;
import com.sa.mongo.model.CreditCardResponseObject;
import com.sa.mongo.service.CheckoutService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;


@Service("checkoutService")
public class CheckoutServiceImpl implements CheckoutService{
	
    @Autowired
    CheckoutServiceImpl() {
        Stripe.apiKey = "sk_test_51NAjB1GxFE5twCSxg71wHtpnpmW13A3PNOwJ4O2hL0D2c5RrLsI0ERKOtDnZ1tHrf0XhHveVkLteG6kO3qcwMsUZ00Jghf80o2";
    }

	@Override
	public ResponseEntity<?> checkout(CreditCardRequestObject creditCardReqObject) {
		
		Charge charge = null;
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("amount", creditCardReqObject.getPrice());
			params.put("currency", creditCardReqObject.getCurrency());
	//		params.put("description", creditCardReqObject.getDescription());
			params.put("source", creditCardReqObject.getToken());
			
			charge = Charge.create(params);
			CreditCardResponseObject response = new CreditCardResponseObject();
			response.setId(charge.getId());
			return ResponseEntity.ok(response);
			

		} catch(StripeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}

}
