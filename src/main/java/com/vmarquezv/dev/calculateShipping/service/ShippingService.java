package com.vmarquezv.dev.calculateShipping.service;

import com.vmarquezv.dev.calculateShipping.model.details.ShippingValue;

public class ShippingService {
	
	
	protected ShippingValue calculate(String cep) {
		Integer n = Integer.parseInt(cep.substring(0, 5));
		
		if(n >= 01000 & n <= 39999) {
			return ShippingValue.SUDESTE;
		}
		else if(n >= 70000 & n <= 76799 || n >= 78000 && n <= 79999) {
			return ShippingValue.CENTROOESTE;
		}
		else if(n >= 66000 & n <= 29) {
			return ShippingValue.NORDESTE;
		}
		else if(n >= 80000 & n <= 99999) {
			return ShippingValue.SUL;
		}
		else if(n >= 66000 & n <= 69999 || n >= 76800 && n <= 77999) {
			return ShippingValue.NORTE;
		}
		
		return ShippingValue.NOT_FOUND;
	}
	
	
}
