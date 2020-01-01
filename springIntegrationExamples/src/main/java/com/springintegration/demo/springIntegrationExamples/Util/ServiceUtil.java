package com.springintegration.demo.springIntegrationExamples.Util;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceUtil {

	public CurrencyConversionBean callCurrencyService(String from, String to, BigDecimal quantity) {

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/" + from + "/to/" + to, CurrencyConversionBean.class);

		CurrencyConversionBean bean = responseEntity.getBody();
		bean.getConversionMultiple();
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));

		return bean;
	}

}
