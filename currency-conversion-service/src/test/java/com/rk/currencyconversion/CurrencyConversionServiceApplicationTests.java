package com.rk.currencyconversion;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rk.currencyconversion.feignclient.CurrencyExchangeServiceProxy;
import com.rk.currencyconversion.model.CurrencyConversionBean;
import com.rk.currencyconversion.rest.CurrencyConversionController;

@SpringBootTest
class CurrencyConversionServiceApplicationTests {
	@InjectMocks
	CurrencyConversionController currencyConversionController;

	@Mock
	CurrencyExchangeServiceProxy exchangeServiceProxy;

	@Mock
	private RestTemplate restTemplate;
	@Mock
	CurrencyConversionBean currencyConversionBean;

	@Test
	public void testConvertCurrency() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Map<String, String> uriVariables = new HashMap<>();
		BigDecimal bg = new BigDecimal("98.123");
		uriVariables.put("from", "USD");
		uriVariables.put("to", "INR");
		CurrencyConversionBean CurrencyConversionBean = new CurrencyConversionBean();
		CurrencyConversionBean.setId(1245L);
		CurrencyConversionBean.setFrom("USD");
		CurrencyConversionBean.setTo("INR");
		CurrencyConversionBean.setConversionMuttiple((new BigDecimal(65)));
		CurrencyConversionBean.setQuantity(new BigDecimal(1000));
		CurrencyConversionBean.setTootalCalculateAmount((new BigDecimal(150)));
		CurrencyConversionBean.setPort(8000);
		Mockito.when(exchangeServiceProxy.retrivewExchangeValue(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(CurrencyConversionBean);
		when(restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR",
				CurrencyConversionBean.class, uriVariables))
						.thenReturn(new ResponseEntity<CurrencyConversionBean>(currencyConversionBean, HttpStatus.OK));
		currencyConversionController.convertCurrency1("USD", "INR", bg);
	}
	/*@Test
	public void testConvertCurrency_test() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Map<String, String> uriVariables = new HashMap<>();
		BigDecimal bg = new BigDecimal("98.123");
		uriVariables.put("from", "USD");
		uriVariables.put("to", "INR");

		CurrencyConversionBean CurrencyConversionBean = new CurrencyConversionBean();
		CurrencyConversionBean.setId(1245L);
		CurrencyConversionBean.setFrom("USD");
		CurrencyConversionBean.setTo("INR");
		CurrencyConversionBean.setConversionMuttiple((new BigDecimal(65)));
		CurrencyConversionBean.setQuantity(new BigDecimal(1000));
		CurrencyConversionBean.setTootalCalculateAmount((new BigDecimal(150)));
		CurrencyConversionBean.setPort(8000);
		Mockito.when(exchangeServiceProxy.retrivewExchangeValue(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(CurrencyConversionBean);
		when(restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR",
				CurrencyConversionBean.class, uriVariables))
						.thenReturn(new ResponseEntity<CurrencyConversionBean>(currencyConversionBean, HttpStatus.OK));
		currencyConversionController.convertCurrency("USD", "INR", bg);
	}*/
	
}
