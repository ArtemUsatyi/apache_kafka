package com.example.kafka_consumer.controller;

import com.example.kafka_consumer.consumer_configuration.MyTopicConsumerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    private final MyTopicConsumerListener myTopic;

    @Autowired
    public ConsumerController(MyTopicConsumerListener myTopic) {
        this.myTopic = myTopic;
    }

    @PostMapping("/get_topic")
    public List<String> listenTopic() {
        List<String> messagesList = myTopic.getMessagesList();
        return messagesList;
    }
}
