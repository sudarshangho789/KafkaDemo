package com.kafka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyrestController {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;


	//http://localhost:9090/?topic=mytest&message=thisissamplemessage
	@GetMapping("/")
	public String sendMessage(@RequestParam("topic") String topic,
			@RequestParam("message") String message,Model m) {
		kafkaTemplate.send(topic, message);
		
		m.addAttribute("myobj", message);
		return "index";

	}
}