package com.knoldus.kafka.kafka;

import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    //kafkaTemplate -->kafkaTemplate is a class from the Spring for Apache Kafka (Spring Kafka) library
    // that provides an easy-to-use interface for sending messages to a Kafka topic.
    // takes care of creating a Producer instance,
    //serializing the message payload, and sending the message to Kafka topic.

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String message){
        logger.info(String.format("Message sent %s", message));

        //The send method of the KafkaTemplate class is used to send messages to Kafka.
        // It takes a String argument representing the topic name and a Message argument
        // representing the message to be sent.
        kafkaTemplate.send("hello", message);
    }
}
