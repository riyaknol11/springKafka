package com.knoldus.kafka.kafka;

import com.knoldus.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

    //code defines a kafkaTemplate field of type KafkaTemplate that uses String as the
    // key serializer and User as the value serializer.

    private KafkaTemplate<String, User> kafkaTemplate;
    //passing user as the byte array to the kafka topic--> Serialization(making it easy to integrate with
    // different data sources and formats)


    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){

        logger.info(String.format("Message sent --> %s", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "hello")
                .build();

        //the Message class is a part of the Spring messaging module and is used to create
        // messages with payloads and headers. The MessageBuilder class provides a convenient
        // way to create a Message instance.

        kafkaTemplate.send(message);
    }



}
