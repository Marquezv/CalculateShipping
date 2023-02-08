package com.vmarquezv.dev.calculateShipping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vmarquezv.dev.calculateShipping.model.details.ShippingValue;

@ExtendWith(MockitoExtension.class)
public class ShippingServiceTest {

	
	@Spy
	@InjectMocks
	private ShippingService service;
	
	private final String CEP = "74550-167";

	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	public void whenCalculateCalled() {
		when(service.calculate(CEP)).thenReturn(ShippingValue.CENTROOESTE);
		
		ShippingValue response = service.calculate(CEP);
		
		assertEquals(response, ShippingValue.CENTROOESTE);
		
	}
	
	
	
	
}
