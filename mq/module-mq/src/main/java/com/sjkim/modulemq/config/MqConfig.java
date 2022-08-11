package com.sjkim.modulemq.config;

import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(value = MqProperty.class)
public class MqConfig {

    @Bean
    public ConnectionFactory connectionFactory(MqProperty mqProperty) {
        var connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(mqProperty.getHost());
        connectionFactory.setPort(mqProperty.getPort());
        connectionFactory.setUsername(mqProperty.getUsername());
        connectionFactory.setPassword(mqProperty.getPassword());
        return connectionFactory;
    }
}
