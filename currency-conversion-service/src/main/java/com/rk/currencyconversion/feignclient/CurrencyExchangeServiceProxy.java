package com.rk.currencyconversion.feignclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rk.currencyconversion.model.CurrencyConversionBean;


@FeignClient(name="currency-exchange-service")
//@FeignClient(name="currency-exchange-service",url="localhost:8000")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrivewExchangeValue(@PathVariable String from,@PathVariable String to);
	//public CurrencyConversionBean retrivewExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);

}
