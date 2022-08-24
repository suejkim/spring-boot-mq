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
    public Queue queue() {
        return new Queue("sample");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("sample-topic");
    }

    @Bean
    public Queue sampleOneQueue() {
        return new Queue("sample-one-queue");
    }

    @Bean
    public Queue sampleTwoQueue() {
        return new Queue("sample-two-queue");
    }

    @Bean
    public Binding bindingSampleOne(Queue sampleOneQueue, TopicExchange exchange) {
        return BindingBuilder.bind(sampleOneQueue).to(exchange).with("sample.one");
    }

    @Bean
    public Binding bindingSampleTwo(Queue sampleTwoQueue, TopicExchange exchange) {
        return BindingBuilder.bind(sampleTwoQueue).to(exchange).with("sample.two");
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
