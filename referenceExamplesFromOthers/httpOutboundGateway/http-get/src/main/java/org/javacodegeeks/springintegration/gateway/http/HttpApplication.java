package org.javacodegeeks.springintegration.gateway.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("http-outbound-gateway.xml")
public class HttpApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpApplication.class, args);
	}
}