package com.springintegration.demo.springIntegrationExamples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfig {

	@Bean(name = "welcomeChannel")
	public MessageChannel replyChannel() {
		return new DirectChannel();
	}
}
