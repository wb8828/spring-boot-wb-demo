//package com.spring.demo.kafka.interceptor;
//
//import com.alibaba.fastjson2.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.producer.ProducerInterceptor;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 生产者拦截器
// */
//@Slf4j
//@Component
//public class CustomProducerInterceptor implements ProducerInterceptor {
//    @Override
//    public ProducerRecord onSend(ProducerRecord record) {
//        // 在发送消息前的自定义逻辑
//        log.info("Before sending message: {}", record.value());
//
//        Map<String, Object> recordMap = new HashMap<>();
//        recordMap.put("data", record.value());
//        recordMap.put("author", "wb");
//        recordMap.put("version", "1.0.0");
//        // 可以修改消息内容或其他属性
//        record = new ProducerRecord<>(record.topic(), record.partition(), record.key(), JSON.toJSONString(recordMap));
//        return record;
//    }
//
//    @Override
//    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
//        // 在消息发送完成后的自定义逻辑
//        if (exception == null) {
//            System.out.println("Message sent successfully: " + metadata.offset());
//        } else {
//            System.out.println("Failed to send message: " + exception.getMessage());
//        }
//    }
//
//    @Override
//    public void close() {
//
//    }
//
//    @Override
//    public void configure(Map<String, ?> map) {
//
//    }
//}