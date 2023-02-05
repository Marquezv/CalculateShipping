package com.vmarquezv.dev.calculateShipping.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShippingResponse {
	
	public ShippingResponse(ViaCepResponse viaCepResponse) {
		super();
		this.cep = viaCepResponse.getCep();
		this.rua = viaCepResponse.getLogradouro();
		this.complemento = viaCepResponse.getComplemento();
		this.bairro = viaCepResponse.getBairro();
		this.cidade = viaCepResponse.getLocalidade();
		this.estado = viaCepResponse.getUf();
		this.frete = null;
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
