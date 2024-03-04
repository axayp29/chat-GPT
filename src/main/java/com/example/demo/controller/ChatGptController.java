package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ChatGptRequest;
import com.example.demo.dto.ChatGptResponse;

@RestController
public class ChatGptController {

	@Autowired
	private RestTemplate restTemplate;

	private static final String URL = "https://api.openai.com/v1/completions";

	private static final String MODEL = "gpt-3.5-turbo-instruct";

	@GetMapping(value = "/chat")
	private List<String> callGPT(@RequestParam("prompt") String prompt) {

		ChatGptRequest chatGptRequest = new ChatGptRequest();
		chatGptRequest.setModel(MODEL);
		chatGptRequest.setPrompt(prompt);

		ChatGptResponse chatGptResponse = restTemplate.postForObject(URL, chatGptRequest, ChatGptResponse.class);

		List<String> response = new ArrayList<>();

		chatGptResponse.getChoices().stream().forEach(x -> response.add(x.getText()));

		return response;
	}
}
