package com.sample.rabbitmq.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class QueueProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String message) {
    	log.info("Trying to send message->{}", message);
        rabbitTemplate.convertAndSend(this.queue.getName(), message);
        log.info("Message sent on to Queue->{}",this.queue.getName());
    }
}
