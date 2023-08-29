package com.spring.demo;

import com.spring.demo.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/kafka")
public class TestKafka {

    @Autowired
    private KafkaProducer producer;

    @GetMapping("/send/{topic}")
    public void send(@PathVariable String topic) {
        producer.send(topic);
    }
}