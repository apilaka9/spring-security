package com.pilaka.spring_security.service;



import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProjectProducer {

    private static final String TOPIC = "project-events";

    private final KafkaTemplate<String, String> kafkaTemplate;



    public ProjectProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Message sent: " + message);
    }
}