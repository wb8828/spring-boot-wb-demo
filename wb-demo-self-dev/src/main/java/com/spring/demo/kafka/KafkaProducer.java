package com.spring.demo.kafka;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


/**
 * kafka生产者
 */
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate kafkaTemplate;

    /**
     * kafka消息发送
     */
    public void send(String topic){
        kafkaTemplate.send(topic,"123");
    }
}