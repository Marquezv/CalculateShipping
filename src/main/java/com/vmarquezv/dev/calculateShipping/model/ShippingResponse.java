package com.vmarquezv.dev.calculateShipping.model;

import java.math.BigDecimal;

import com.vmarquezv.dev.calculateShipping.model.details.ShippingValue;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShippingResponse {
	
	public ShippingResponse(ViaCepResponse viaCepResponse, ShippingValue shippingValue) {
		super();
		this.cep = viaCepResponse.getCep();
		this.rua = viaCepResponse.getLogradouro();
		this.complemento = viaCepResponse.getComplemento();
		this.bairro = viaCepResponse.getBairro();
		this.cidade = viaCepResponse.getLocalidade();
		this.estado = viaCepResponse.getUf();
		this.frete = shippingValue.getFrete();
		this.regiao = shippingValue.getRegiao();
	}
	private String cep;
	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String regiao;
	private BigDecimal frete;
}
