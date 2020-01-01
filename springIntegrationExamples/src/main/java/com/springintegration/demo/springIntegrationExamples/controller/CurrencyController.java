package com.springintegration.demo.springIntegrationExamples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springintegration.demo.springIntegrationExamples.Util.CurrencyConversionBean;
import com.springintegration.demo.springIntegrationExamples.service.IntegrationGateway;

@RestController
@RequestMapping("/currencyController")
public class CurrencyController {

	@Autowired
	private IntegrationGateway integrationGateway;

	@PostMapping("/convert")
	public CurrencyConversionBean convert(@RequestBody CurrencyConversionBean bean) {
		return integrationGateway.convertCurrenvyGateway(bean);
	}

}
