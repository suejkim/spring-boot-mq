package com.sjkim.modulemq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("queue2")
public class QueueProperty {
    private String name1;
    private String name2;
    private String exchangeName;
    private String routingKey1;
    private String routingKey2;
}