package com.spring.demo.kafka.interceptor;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消费者拦截器
 */
@Slf4j
@Component
public class CustomConsumerInterceptor implements ConsumerInterceptor<Object,Object> {
    @Override
    public ConsumerRecords onConsume(ConsumerRecords<Object,Object> records) {
        // 消息进行预处理、日志记录、性能监控等操作，并不会改变消息的内容

//        records.forEach(record ->{
//            if (StringUtils.equals("test-kafka", record.topic())){
//                String jsonStr = record.value().toString();
//                JSONObject jsonObject = JSONObject.parseObject(jsonStr);
//                String data = JSON.toJSONString(jsonObject.getOrDefault("data", StringUtils.EMPTY));
//                record = new ConsumerRecord<>(record.topic(), record.partition(), record.offset(), record.key(), data);
//
//            }
//        });

        return records;
    }

    @Override
    public void close() {

    }

    @Override
    public void onCommit(Map map) {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}