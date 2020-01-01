package com.springintegration.demo.springIntegrationExamples.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.springintegration.demo.springIntegrationExamples.Util.CurrencyConversionBean;

@MessagingGateway
public interface IntegrationGateway {

	@Gateway(requestChannel = "first.channel.demo")
	public String sendMessage(String inputString);

	@Gateway(requestChannel = "currency.convert.channel")
	public CurrencyConversionBean convertCurrenvyGateway(CurrencyConversionBean bean);

}
