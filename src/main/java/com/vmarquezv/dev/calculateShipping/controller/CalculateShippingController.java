package com.vmarquezv.dev.calculateShipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmarquezv.dev.calculateShipping.exception.BadRequestException;
import com.vmarquezv.dev.calculateShipping.model.ShippingResponse;
import com.vmarquezv.dev.calculateShipping.service.CalculateShippingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("")
public class CalculateShippingController {
	
	@Autowired
	private CalculateShippingService service;
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "CEP - NOT_FOUND" ),
			@ApiResponse(code = 400, message = "CEP - INCORRECT_REQUEST")
	})
	@ApiOperation(value = "CalculateShipping - calculate frete with CEP")
	public ResponseEntity<ShippingResponse> getCep(@RequestBody String cep) {
		
		if(cep == null || cep.isEmpty()) throw new BadRequestException();
		
		return ResponseEntity.ok(service.calculateShipping(cep));
	}
	
	
}
