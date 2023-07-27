package com.spring.demo.config;

import com.spring.demo.interceptor.AuthChannelInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket配置
 */
@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private AuthChannelInterceptor authChannelInterceptor;


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")//请求地址:http://ip:port/ws
                .setAllowedOriginPatterns("*")//跨域
                .withSockJS();//开启socketJs
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 定义了一个客户端订阅的前缀信息，也就是客户端接收服务端发送消息的前缀消息
        registry.enableSimpleBroker("/queue", "/topic");
        // 设置了应用程序目的地前缀，它表示客户端发送消息时的目标前缀。例如，如果客户端发送消息到"/app/hello"，则该消息将被路由到服务器端的控制器方法。
        registry.setApplicationDestinationPrefixes("/app");//注意此处有设置
        // 这一行设置了用户目的地前缀，它表示用户特定的目的地。这通常用于点对点通信，其中用户可以直接发送消息给其他用户。例如，如果用户A发送消息到"/user/B"，则该消息将被路由到用户B
        registry.setUserDestinationPrefix("/user");
    }

    /**
     * 拦截器方式2
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(authChannelInterceptor);
    }

}
