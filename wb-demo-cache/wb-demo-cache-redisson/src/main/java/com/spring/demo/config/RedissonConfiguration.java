package com.spring.demo.config;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wb
 * @description: Redisson配置类
 * @date: 2023-04-10 15:28
 */
@Configuration
public class RedissonConfiguration {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public RedissonClient getRedissonClient() {
        Config config = new Config();

        if (redisProperties.getCluster() != null) {
            //集群模式配置
            List<String> nodes = redisProperties.getCluster().getNodes();

            List<String> clusterNodes = new ArrayList<>();
            for (String node : nodes) {
                clusterNodes.add("redis://" + node);
            }
            ClusterServersConfig clusterServersConfig = config.useClusterServers().addNodeAddress(clusterNodes.toArray(new String[clusterNodes.size()]));

            if (!StringUtils.isEmpty(redisProperties.getPassword())) {
                clusterServersConfig.setPassword(redisProperties.getPassword());
            }
        } else {
            //单节点配置
            String address = "redis://" + redisProperties.getHost() + ":" + redisProperties.getPort();
            SingleServerConfig serverConfig = config.useSingleServer();
            serverConfig.setAddress(address);
            if (!StringUtils.isEmpty(redisProperties.getPassword())) {
                serverConfig.setPassword(redisProperties.getPassword());
            }
            serverConfig.setDatabase(redisProperties.getDatabase());
        }
        //看门狗的锁续期时间，默认30000ms，这里配置成15000ms
        config.setLockWatchdogTimeout(15000);
        return Redisson.create(config);
    }
}