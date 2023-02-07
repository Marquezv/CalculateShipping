package com.vmarquezv.dev.calculateShipping.model.details;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum ShippingValue {
	
	SUDESTE("Sudeste", new BigDecimal("7.85")),
	CENTROOESTE("Centro-Oeste", new BigDecimal("12.50")),
	NORDESTE("Nordeste", new BigDecimal("15.98")),
	SUL("Sul", new BigDecimal("17.30")),
	NORTE("Norte", new BigDecimal("20.83")),
	
	NOT_FOUND("", new BigDecimal("0"));
	
    private String regiao;
	private BigDecimal frete;
	
	public String getRegiao() {
		return regiao;
	}
	public BigDecimal getFrete() {
		return frete;
	}
	
	
}
