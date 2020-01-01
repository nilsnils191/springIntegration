package org.javacodegeeks.springintegration.gateway.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.AccountsData;

@RestController
@RequestMapping("/httpGet/accounts")
public class AccountsController {

	@Autowired
	@Qualifier("get_send_channel")
	MessageChannel getSendChannel;

	@Autowired
	@Qualifier("get_receive_channel")
	PollableChannel getReceiveChannel;

	@RequestMapping("/testHttpOutboundGateway")
	public String testHttpOutboundGateway() {
		Message<String> message = MessageBuilder.withPayload("").build();
		getSendChannel.send(message);
		String payloadData = (String) getReceiveChannel.receive().getPayload();
		return payloadData;
	}

}
