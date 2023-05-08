package com.knoldus.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

@Bean
    public NewTopic topicBean(){
        return TopicBuilder.name("hello")
                .build();
    }
}
