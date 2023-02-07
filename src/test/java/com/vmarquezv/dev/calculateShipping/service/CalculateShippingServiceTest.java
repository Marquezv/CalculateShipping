package com.vmarquezv.dev.calculateShipping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.text.MessageFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.vmarquezv.dev.calculateShipping.model.ShippingResponse;
import com.vmarquezv.dev.calculateShipping.model.ViaCepResponse;
import com.vmarquezv.dev.calculateShipping.model.details.ShippingValue;

@ExtendWith(MockitoExtension.class)
public class CalculateShippingServiceTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private CepService checkCep;
	
	@Spy
	@InjectMocks
	private CalculateShippingService service;
	
	private ShippingResponse shippingResponse;
	private ViaCepResponse viaCepResponse;
	
	private final String CEP = "01001-000";
	private final String URL = MessageFormat.format("https://viacep.com.br/ws/{0}/json/", CEP);
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startUser();
	}
	
	@Test
	public void whenCalculateShippingCalled() {
		when(service.calculateShipping(CEP))
				.thenReturn(new ShippingResponse(viaCepResponse, ShippingValue.SUDESTE));
		
		ShippingResponse response = service.calculateShipping(CEP);
	    assertEquals(response, shippingResponse);
	}
	
	@Test
	public void whenToShippingResponse() {
		when(service.toShippingResponse(viaCepResponse)).thenReturn(shippingResponse);
		
		ShippingResponse response = service.toShippingResponse(viaCepResponse);
	    assertEquals(response, shippingResponse);
	}
	
	@Test
	public void whenRequestCepResponse() {
		lenient().when(restTemplate.getForObject(URL, ViaCepResponse.class)).thenReturn(viaCepResponse);
		
		ViaCepResponse response = service.requestCep(CEP);
		
	    assertEquals(response, viaCepResponse);
	}
	
	
	private void startUser() {
		viaCepResponse = new ViaCepResponse(CEP, "Praça da Sé", "lado ímpar", "Sé", "São Paulo", "SP", "3550308", "1004", "11", "7107");
		shippingResponse = new ShippingResponse(viaCepResponse, ShippingValue.SUDESTE);
	}
	
}
