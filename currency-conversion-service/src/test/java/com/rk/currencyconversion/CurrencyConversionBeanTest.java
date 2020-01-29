package com.rk.currencyconversion;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rk.currencyconversion.model.CurrencyConversionBean;	
@SpringBootTest
public class CurrencyConversionBeanTest {
	
	@Test
	public void currencyConstractor() {
		
		CurrencyConversionBean bean =new CurrencyConversionBean();
	}
	
	@Test
	public void currencyConstractor_arrgs() {
		
		CurrencyConversionBean bean =new CurrencyConversionBean(1l,"USD","INR",new BigDecimal(12),new BigDecimal(12),new BigDecimal(10),123);
	}
	
	@Test
	public void currencyConstractor_setter() {
		
		CurrencyConversionBean bean =new CurrencyConversionBean();
		bean.setId(1l);
		bean.setFrom("USD");
		bean.setTo("INR");
		bean.setConversionMuttiple(new BigDecimal(10));
		bean.setQuantity(new BigDecimal(10));
		bean.setTootalCalculateAmount(new BigDecimal(10));
		bean.setPort(123);
		
				 
	}
	

}
