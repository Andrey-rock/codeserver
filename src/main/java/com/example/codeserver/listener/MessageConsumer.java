package com.example.codeserver.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "my-group")
    public void consume(String message) {
        logger.info("Received message: {}", message);
        processMessage(message);
    }

    private void processMessage(String message) {
        System.out.println(message);
    }
}