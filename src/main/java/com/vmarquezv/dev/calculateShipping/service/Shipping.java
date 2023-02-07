package com.vmarquezv.dev.calculateShipping.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.vmarquezv.dev.calculateShipping.model.details.ShippingValue;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {

	private String cep;
	private String regiao;
	private BigDecimal frete;
	

	public Shipping(String cep) {
		this.cep = cep;
	}

	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getRegiao() {
		return regiao;
	}

	public BigDecimal getFrete() {
		return frete;
	}

	
	public ShippingValue shippingCalculate() {
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
