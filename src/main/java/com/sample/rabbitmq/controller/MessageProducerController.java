package com.sample.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rabbitmq.producer.QueueProducer;

@RestController
public class MessageProducerController {

	@Autowired
	private QueueProducer queueProducer;

	@GetMapping("/v1/publish")
	public ResponseEntity<String> publishMessage(@RequestParam(name = "message", required = true) String message) {
		queueProducer.send(message);
		return ResponseEntity.ok("MessageSent");
	}
}
