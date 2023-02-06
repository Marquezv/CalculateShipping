package com.vmarquezv.dev.calculateShipping.service;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vmarquezv.dev.calculateShipping.exception.BadRequestException;
import com.vmarquezv.dev.calculateShipping.exception.ObjectNotFoundException;
import com.vmarquezv.dev.calculateShipping.model.CepRequest;
import com.vmarquezv.dev.calculateShipping.model.ShippingResponse;
import com.vmarquezv.dev.calculateShipping.model.ViaCepResponse;

@Service
public class CalculateShippingService {
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private CheckCep checkCpf;
	
	public ShippingResponse requestCep(CepRequest cepRequest) {
		String cep = cepRequest.getCep();
		
		cep = cep.replaceAll("[^a-zA-Z0-9]", "");
		if(!checkCpf.isValid(cep)) {
			
			throw new BadRequestException();
		}
		
		String url = MessageFormat.format(
				"https://viacep.com.br/ws/{0}/json/", 
				cep);
		
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity(url, Object.class);
		
		String obj = responseEntity.getBody().toString();
		
		ViaCepResponse response = restTemplate.getForObject(url, ViaCepResponse.class);
		
		if(obj.equals("{erro=true}")) throw new ObjectNotFoundException();
		
		return toShippingResponse(response);
	}
	
	
	public ShippingResponse toShippingResponse(ViaCepResponse viaCep) {
		ShippingResponse response = new ShippingResponse(viaCep);
		String regiao = findRegiao(viaCep);
		response.setRegiao(regiao);
				
		if(regiao != null) response.setFrete(calculateFrete(response.getRegiao()));
		
		return response;
	}
	
	
	
	private String findRegiao(ViaCepResponse viaCep) {
		String regiao = null;
		String cep = viaCep.getCep();
		
		if(cep == null) return null;
			
		Integer n = Integer.parseInt(cep.substring(0, 5));
		
		if(n >= 01000 & n <= 39999) {
			regiao = "Sudeste";
		}
		else if(n >= 70000 & n <= 76799 || n >= 78000 && n <= 79999) {
			regiao = "CentroOeste";
		}
		else if(n >= 66000 & n <= 29) {
			regiao = "Nordeste";
		}
		else if(n >= 80000 & n <= 99999) {
			regiao = "Sul";
		}
		else if(n >= 66000 & n <= 69999 || n >= 76800 && n <= 77999) {
			regiao = "Norte";
		}
		
		return regiao;
	}
	
	
	private BigDecimal calculateFrete(String regiao) {
		BigDecimal frete = new BigDecimal("0.00");
		
		switch (regiao) {
		case "Sudeste":
			frete = new BigDecimal("7.85");
			break;
		case "CentroOeste":
			frete = new BigDecimal("12.50");
			break;
		case "Nordeste":
			frete = new BigDecimal("15.98");
			break;
		case "Sul":
			frete = new BigDecimal("17.30");
			break;
		case "Norte":
			frete = new BigDecimal("20.83");
			break;
		default:
			break;
		}
		
		return frete;
	}
}














