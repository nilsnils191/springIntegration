package com.springintegration.demo.springIntegrationExamples.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {

	
	@ServiceActivator(inputChannel = "first.channel.demo")
	public void serviceActivatorSample(Message<String> message) throws MessagingException {

		MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
		MessageBuilder.fromMessage(	message);
		Message<String> newMessage = MessageBuilder.withPayload("Welcome " + message.getPayload() + " !!!!!!!!!")
				.build();
		replyChannel.send(newMessage);
	}
	
	
}
