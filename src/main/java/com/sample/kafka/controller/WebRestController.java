package com.sample.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.kafka.services.MessageProducer;
import com.sample.kafka.storage.MessageStorage;

@RestController
@RequestMapping(value="/kafka")
public class WebRestController {
	
	@Autowired
	MessageProducer producer;
	
	@Autowired
	MessageStorage storage;
	
	@GetMapping(value="/producer")
	public String producer(@RequestParam("data")String data){
		producer.send(data);
		
		return "Done";
	}
	
	@GetMapping(value="/consumer")
	public String getAllRecievedMessage(){
		String messages = storage.toString();
		storage.clear();
		
		return messages;
	}
}
