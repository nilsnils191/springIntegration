package com.springintegration.demo.springIntegrationExamples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springintegration.demo.springIntegrationExamples.service.IntegrationGateway;

@RestController
@RequestMapping("/integration")
public class IntegrationController {

	@Autowired
	private IntegrationGateway integrationGateway;

	@GetMapping("/{name}")
	public String getWelcomeMessage(@PathVariable("name") String name) {
		return integrationGateway.sendMessage(name);
	}
	
	 
}
