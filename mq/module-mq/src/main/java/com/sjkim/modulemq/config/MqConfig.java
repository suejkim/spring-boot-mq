package com.sjkim.modulemq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@EnableConfigurationProperties(value = {MqProperty.class, BasicQueueProperty.class, QueueProperty.class})
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
    public Queue queue(BasicQueueProperty property) {
        return new Queue(property.getName(), property.isDurable());
    }

    @Bean
    public TopicExchange exchange(QueueProperty property) {
        return new TopicExchange(property.getExchangeName());
    }

    @Bean
    public Queue sampleOneQueue(QueueProperty property) {
        return new Queue(property.getName1());
    }

    @Bean
    public Queue sampleTwoQueue(QueueProperty property) {
        return new Queue(property.getName2());
    }

    @Bean
    public Binding bindingSampleOne(Queue sampleOneQueue, TopicExchange exchange, QueueProperty property) {
        return BindingBuilder.bind(sampleOneQueue).to(exchange).with(property.getRoutingKey1());
    }

    @Bean
    public Binding bindingSampleTwo(Queue sampleTwoQueue, TopicExchange exchange, QueueProperty property) {
        return BindingBuilder.bind(sampleTwoQueue).to(exchange).with(property.getRoutingKey2());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    /*
    Jackson2JsonMessageConverter 설정하지 않으면 application/x-java-serialized-object
    byte array -> Base64로 인코딩 된다.
     */
}