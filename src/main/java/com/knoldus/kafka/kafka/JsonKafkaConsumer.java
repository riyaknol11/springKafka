package com.knoldus.kafka.kafka;

import com.knoldus.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

//Sping kafka provided Json Deserializer will convert User Json object into Java user object.
    @KafkaListener(topics = "json_topic", groupId = "myGroup")
    public void consume(User user){
        logger.info(String.format("Message received --> %s", user.toString()));
    }
}
