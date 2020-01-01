package com.springintegration.demo.springIntegrationExamples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.springintegration.demo.springIntegrationExamples.Util.CurrencyConversionBean;
import com.springintegration.demo.springIntegrationExamples.Util.ServiceUtil;

@Service
public class IntegrationService {

	@Autowired
	private ServiceUtil util;

	@ServiceActivator(inputChannel = "first.channel.demo")
	public void serviceActivatorSample(Message<String> message) throws MessagingException {

		MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
		MessageBuilder.fromMessage(message);
		Message<String> newMessage = MessageBuilder.withPayload("Welcome " + message.getPayload() + " !!!!!!!!!")
				.build();
		replyChannel.send(newMessage);
	}

	@ServiceActivator(inputChannel = "currency.convert.channel")
	public CurrencyConversionBean convertCurrenvyGateway(CurrencyConversionBean bean) {
		return util.callCurrencyService(bean.getFrom(), bean.getTo(), bean.getQuantity());
	}

}
