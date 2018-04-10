package com.sample.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.sample.kafka.storage.MessageStorage;

@Component
public class MessageConsumer {
	private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);

	@Autowired
	MessageStorage storage;
	
	@KafkaListener(topics="${kafka.topic}")
    public void processMessage(String content) {
		log.info("received sample content = '{}'", content);
		storage.put(content);
    }
}
