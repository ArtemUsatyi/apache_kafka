package com.example.kafka_consumer.consumer_configuration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyTopicConsumerListener {

    private final List<String> messagesList = new ArrayList<>();

    @KafkaListener(topics = "MyTopic", groupId = "kafka-sandbox")
    public void listen(String message) {
        synchronized (messagesList) {
            messagesList.add(message);
        }
    }

    public List<String> getMessagesList() {
        return messagesList;
    }
}
