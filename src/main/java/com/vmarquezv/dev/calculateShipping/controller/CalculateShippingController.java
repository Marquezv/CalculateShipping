package com.vmarquezv.dev.calculateShipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmarquezv.dev.calculateShipping.model.Shipping;
import com.vmarquezv.dev.calculateShipping.service.CalculateShippingService;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class CalculateShippingController {
	
	@Autowired
	private CalculateShippingService service;
	
	@GetMapping(value = "/{cep}")
	public Shipping getCep(@PathVariable String cep) {
		return service.requestCep(cep);
	}
	
	
}
