package com.vmarquezv.dev.calculateShipping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.vmarquezv.dev.calculateShipping.model.CepRequest;
import com.vmarquezv.dev.calculateShipping.model.ShippingResponse;
import com.vmarquezv.dev.calculateShipping.model.ViaCepResponse;

@ExtendWith(MockitoExtension.class)
public class CalculateShippingServiceTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private CheckCep checkCep;
	
	@Spy
	@InjectMocks
	private CalculateShippingService service;
	
	private ShippingResponse shippingResponse;
	private ViaCepResponse viaCepResponse;
	private CepRequest cepRequest;
	
	private final String CEP = "01001000";
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	
	@Test
	private void whenCalculateShippingCalled() {
		when(service.calculateShipping(cepRequest))
				.thenReturn(new ShippingResponse(viaCepResponse));
		
		ShippingResponse response = service.calculateShipping(cepRequest);
	    assertEquals(response, shippingResponse);
	}
	
	@Test
	private void whenToShippingResponse() {
		when(service.toShippingResponse(viaCepResponse)).thenReturn(shippingResponse);
		
		ShippingResponse response = service.toShippingResponse(viaCepResponse);
	    assertEquals(response, shippingResponse);
	}
	
	
	
	private void startUser() {
		viaCepResponse = new ViaCepResponse(CEP, "Praça da Sé", "lado ímpar", "Sé", 	"São Paulo", "SP", "3550308", "1004", "11", "7107");
		shippingResponse = new ShippingResponse(viaCepResponse);
		cepRequest = new CepRequest(CEP);
	}
	
}
