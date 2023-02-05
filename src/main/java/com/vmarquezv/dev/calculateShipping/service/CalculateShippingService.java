package com.vmarquezv.dev.calculateShipping.service;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vmarquezv.dev.calculateShipping.exception.ObjectNotFoundException;
import com.vmarquezv.dev.calculateShipping.model.ShippingResponse;
import com.vmarquezv.dev.calculateShipping.model.ViaCepResponse;

@Service
public class CalculateShippingService {
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private CheckCep checkCpf;
	
	public ShippingResponse requestCep(String cep) {
		
		if(checkCpf.isValid(cep)) {
			String url = MessageFormat.format(
					"https://viacep.com.br/ws/{0}/json/", 
					cep);
			
			ViaCepResponse response = restTemplate.getForObject(url, ViaCepResponse.class);
			
			return toShippingResponse(response);
		}
		
		throw new ObjectNotFoundException("CEP - NOT_FOUND");
	}
	
	
	public ShippingResponse toShippingResponse(ViaCepResponse viaCep) {
		
		ShippingResponse response = new ShippingResponse(viaCep);
		
		
		return response;
	}
	
	
}
