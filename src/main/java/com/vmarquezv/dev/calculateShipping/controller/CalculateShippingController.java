package com.vmarquezv.dev.calculateShipping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmarquezv.dev.calculateShipping.exception.ObjectNotFoundException;
import com.vmarquezv.dev.calculateShipping.model.ShippingResponse;
import com.vmarquezv.dev.calculateShipping.service.CalculateShippingService;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class CalculateShippingController {
	
	@Autowired
	private CalculateShippingService service;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<ShippingResponse> getCep(@RequestBody Map<String, Object> cepRequest) {
		String cep = cepRequest.get("cep").toString();
		
		if(cep == "" || cep.equals(null)) throw new ObjectNotFoundException("CEP - INVALID");
		
		return ResponseEntity.ok(service.requestCep(cep));
	}
	
	
}
