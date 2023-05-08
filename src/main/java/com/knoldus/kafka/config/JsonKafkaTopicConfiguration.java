package com.knoldus.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

public class JsonKafkaTopicConfiguration {

    public NewTopic jsonTopic(){
        return TopicBuilder.name("json_topic")
                .build();
    }
}
