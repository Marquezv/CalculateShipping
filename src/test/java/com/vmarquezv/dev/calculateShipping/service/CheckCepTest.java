package com.vmarquezv.dev.calculateShipping.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class CheckCepTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private CheckCep checkCep;
	
	@Spy
	@InjectMocks
	private CalculateShippingService service;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startUser();
	}
	
	
	private void startUser() {
	}
	
}

	
