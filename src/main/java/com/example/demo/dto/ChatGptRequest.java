package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatGptRequest {
	
	private String model;
	
	private String prompt;
	
	private int temperature = 1;
	
	private int  max_tokens = 256;
	
	private int top_p = 1;
	
	private int frequency_penalty = 0;
	
	private int presence_penalty = 0;
	 
}
