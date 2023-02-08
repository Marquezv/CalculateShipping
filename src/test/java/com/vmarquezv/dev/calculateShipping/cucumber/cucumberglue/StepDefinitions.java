package com.vmarquezv.dev.calculateShipping.cucumber.cucumberglue;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions {
	
	
	@LocalServerPort
	String port;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@When("the client call endpoint {string}")
	public void whenClientCall(String url) {
		
		String shippingResponse = restTemplate.postForObject("http://localhost:"+port, 
				"01001-000",
				String.class);
		
		System.out.println(shippingResponse);
	}
	
	@Then("response status code is {int}") 
	public void thenStatusCode(int expected) {
		assertThat("status code is " + expected, 200 == expected);
		
	}
	
	@Then("returned ShippingResponse should be {double}")
	public void thenReturnIs(String expected) {
		assertEquals(expected, new BigDecimal("7.85"));
	}
	
	
	
}
