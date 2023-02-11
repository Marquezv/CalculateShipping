package com.vmarquezv.dev.calculateShipping.service;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vmarquezv.dev.calculateShipping.exception.BadRequestException;
import com.vmarquezv.dev.calculateShipping.exception.ObjectNotFoundException;
import com.vmarquezv.dev.calculateShipping.model.Shipping;
import com.vmarquezv.dev.calculateShipping.model.ShippingResponse;
import com.vmarquezv.dev.calculateShipping.model.ViaCepResponse;
import com.vmarquezv.dev.calculateShipping.model.details.ShippingValue;


@Service
public class CalculateShippingService  {
	
	private final String URL = "https://viacep.com.br/ws/{0}/json/";
	
	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CepService cepService;
	
	public ShippingResponse calculateShipping(String cepRequest) {
		String cep = cepRequest.replaceAll("[^a-zA-Z0-9]", "");
		
		if(!cepService.isValid(cep)) throw new BadRequestException();
		
		ViaCepResponse viaCepResponse = requestCep(cep);
		
		return toShippingResponse(viaCepResponse);
	}
	
	protected ViaCepResponse requestCep(String cep) {
		
		ViaCepResponse response = restTemplate.getForObject(
				MessageFormat.format(URL, cep),
				ViaCepResponse.class);
		
		if(response.getCep() == null) throw new ObjectNotFoundException();
		
		return response;
	}
	
	
	protected ShippingResponse toShippingResponse(ViaCepResponse viaCep) {
		
		ShippingValue shippingValue = new Shipping().calculate(viaCep.getCep());
		
		return new ShippingResponse(viaCep, shippingValue);
	}
	
}













