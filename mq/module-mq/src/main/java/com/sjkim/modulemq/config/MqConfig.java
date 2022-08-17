package com.sjkim.modulemq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@EnableConfigurationProperties(value = {MqProperty.class, QueueProperty.class})
public class MqConfig {
    @Bean
    public ConnectionFactory connectionFactory(MqProperty mqProperty) {
        var connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(mqProperty.getHost());
        connectionFactory.setPort(mqProperty.getPort());
        connectionFactory.setUsername(mqProperty.getUsername());
        connectionFactory.setPassword(mqProperty.getPassword());
        return connectionFactory;
    }

    @Bean
    public Queue queue(QueueProperty queueProperty) {
        return new Queue(queueProperty.getName(), queueProperty.isDurable());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    // application/x-java-serialized-object -> application/json
//    @Bean
//    public Jackson2JsonMessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
}
