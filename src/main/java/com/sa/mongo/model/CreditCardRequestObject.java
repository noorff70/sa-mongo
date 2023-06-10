package com.sa.mongo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
public class CreditCardRequestObject {
	
	private String token;
	private int price;
	private String currency;
	private String description;

}
