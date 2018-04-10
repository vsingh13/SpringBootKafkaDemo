package com.sample.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
	private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka.topic}")
	String kafkaTopic = "sample-test";
	
	public void send(String data) {
	    log.info("sending sample data='{}'", data);
	    
	    kafkaTemplate.send(kafkaTopic, data);
	}
}
