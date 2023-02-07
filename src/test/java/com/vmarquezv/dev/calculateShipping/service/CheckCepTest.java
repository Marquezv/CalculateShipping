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

@ExtendWith(MockitoExtension.class)
public class CheckCepTest {
	
	@Spy
	@InjectMocks
	private CheckCep service;
	
	private final String CEP = "01001-000";

	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void whenIsValidCalled() {
		when(service.isValid(CEP)).thenReturn(true);
		
		boolean isValid = service.isValid(CEP);
		assertEquals(isValid, true);
	}
	
	
}

	
