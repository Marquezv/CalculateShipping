package com.vmarquezv.dev.calculateShipping.service;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vmarquezv.dev.calculateShipping.exception.BadRequestException;
import com.vmarquezv.dev.calculateShipping.exception.ObjectNotFoundException;
import com.vmarquezv.dev.calculateShipping.model.CepRequest;
import com.vmarquezv.dev.calculateShipping.model.ShippingResponse;
import com.vmarquezv.dev.calculateShipping.model.ViaCepResponse;
import com.vmarquezv.dev.calculateShipping.model.details.ShippingValue;


@Service
public class CalculateShippingService  {
	
	private final String URL = "https://viacep.com.br/ws/{0}/json/";
	
	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CheckCep checkCep;
	
	public ShippingResponse calculateShipping(CepRequest cepRequest) {
		String cep = cepRequest.getCep().replaceAll("[^a-zA-Z0-9]", "");
		
		if(checkCep.isValid(cep)) throw new BadRequestException();
		
		ViaCepResponse viaCepResponse =	requestCep(cep);
		
		toShippingResponse(viaCepResponse);
		
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
		ShippingResponse response = new ShippingResponse(viaCep);
		ShippingValue shippingData = new Shipping(viaCep.getCep()).shippingCalculate();
		
		response.setFrete(shippingData.getFrete());
		response.setRegiao(shippingData.getRegiao());
		
		return response;
	}
	
}













