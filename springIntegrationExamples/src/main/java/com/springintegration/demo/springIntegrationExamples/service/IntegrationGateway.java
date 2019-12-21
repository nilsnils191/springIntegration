package com.springintegration.demo.springIntegrationExamples.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {

	@Gateway(requestChannel = "first.channel.demo")
	public String sendMessage(String inputString);
	
}
