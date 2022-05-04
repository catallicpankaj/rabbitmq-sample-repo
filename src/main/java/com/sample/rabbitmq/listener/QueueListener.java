package com.sample.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class QueueListener {

    @RabbitListener(queues = "${queue.name}")
    public void receive(String message) {
        log.info("Message is->{}", message);
    }

    
}
