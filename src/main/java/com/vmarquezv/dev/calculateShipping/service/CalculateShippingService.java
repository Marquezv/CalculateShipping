package com.vmarquezv.dev.calculateShipping.service;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vmarquezv.dev.calculateShipping.model.Shipping;

@Service
public class CalculateShippingService {

	@Autowired
	private RestTemplate template = new RestTemplate();
	
	public Shipping requestCep(String cep) {
		String url = MessageFormat.format(
				"https://viacep.com.br/ws/{0}/json/", 
				cep);
		
		return template.getForObject(url, Shipping.class);
	}
	
	
}
