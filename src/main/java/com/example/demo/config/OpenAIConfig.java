package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfig {

	private static final String API_KEY = "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";

	@Bean
	public RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getInterceptors().add((requst, body, exeuction) -> {
			requst.getHeaders().add("Authorization", "Bearer " + API_KEY);
			return exeuction.execute(requst, body);
		});

		return restTemplate;
	}
}
