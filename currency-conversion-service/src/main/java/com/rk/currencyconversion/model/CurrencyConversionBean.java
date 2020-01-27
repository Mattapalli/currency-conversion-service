package com.rk.currencyconversion.model;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMuttiple;
	private BigDecimal quantity;
	private BigDecimal tootalCalculateAmount;
	private int port;
	
	
	public CurrencyConversionBean() {
		
	}

	

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMuttiple, BigDecimal quantity,
			BigDecimal tootalCalculateAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMuttiple = conversionMuttiple;
		this.quantity = quantity;
		this.tootalCalculateAmount = tootalCalculateAmount;
		this.port = port;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public BigDecimal getConversionMuttiple() {
		return conversionMuttiple;
	}


	public void setConversionMuttiple(BigDecimal conversionMuttiple) {
		this.conversionMuttiple = conversionMuttiple;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}


	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getTootalCalculateAmount() {
		return tootalCalculateAmount;
	}


	public void setTootalCalculateAmount(BigDecimal tootalCalculateAmount) {
		this.tootalCalculateAmount = tootalCalculateAmount;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	
	
	

}
