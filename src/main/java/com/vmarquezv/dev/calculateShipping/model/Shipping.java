package com.vmarquezv.dev.calculateShipping.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.vmarquezv.dev.calculateShipping.service.ShippingService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class Shipping extends ShippingService {

	private String cep;
	private String regiao;
	private BigDecimal frete;
	

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
	
}
