//package com.spring.demo.kafka;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
///**
// * kafka消费者
// */
//@Component
//@Slf4j
//public class KafkaConsumer {
//
//    @KafkaListener(topics = {"test-kafka"}, groupId = "test")
//    public void consumer(ConsumerRecord<?, ?> record) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            log.info("----------------- record =" + record);
//            log.info("------------------ message =" + message);
//        }
//    }
//}