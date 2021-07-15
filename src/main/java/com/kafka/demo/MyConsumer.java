package com.kafka.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MyConsumer {

	@KafkaListener(topics = "mytest",groupId = "mygroup")
	public void consumeFromTopic(@RequestParam String msg) {
		System.out.println(msg);
	}
}
