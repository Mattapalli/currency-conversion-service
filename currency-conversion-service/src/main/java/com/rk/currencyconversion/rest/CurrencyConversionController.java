package com.rk.currencyconversion.rest;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rk.currencyconversion.feignclient.CurrencyExchangeServiceProxy;
import com.rk.currencyconversion.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CurrencyExchangeServiceProxy currencyProxy;

	/*@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariable);
		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMuttiple(), quantity,
				quantity.multiply(response.getConversionMuttiple()), response.getPort());

	}*/

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency1(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean response = currencyProxy.retrivewExchangeValue(from, to);
	logger.info("{}", response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMuttiple(), quantity,
				quantity.multiply(response.getConversionMuttiple()), response.getPort());

	}

}
