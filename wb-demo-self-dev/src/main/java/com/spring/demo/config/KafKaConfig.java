//package com.spring.demo.config;
//
//import com.spring.demo.kafka.interceptor.CustomProducerInterceptor;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: 自己的名字
// * @description:
// * @date: 2023-08-28 14:41
// */
//
//@Configuration
//@EnableKafka
//public class KafKaConfig {
//
//    @Autowired
//    private KafkaProperties kafkaProperties;
//
//    @Autowired
//    private CustomProducerInterceptor customProducerInterceptor;
//
//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//        // 键的序列化方式:
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getProducer().getKeySerializer() == null ? "org.apache.kafka.common.serialization.StringSerializer" : kafkaProperties.getProducer().getKeySerializer());
//        // 值的序列化方式：org.apache.kafka.common.serialization.StringSerializer
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getProducer().getValueSerializer() == null ? "org.apache.kafka.common.serialization.StringSerializer" : kafkaProperties.getProducer().getValueSerializer());
//        // 发生错误时重发的次数
//        configProps.put(ProducerConfig.RETRIES_CONFIG, kafkaProperties.getProducer().getRetries() == null ? 0 : kafkaProperties.getProducer().getRetries());
//
//        // 添加拦截器到配置
//        configProps.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, customProducerInterceptor.getClass().getName());
//
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}