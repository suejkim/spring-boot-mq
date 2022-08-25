package com.sjkim.modulemq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("queue1")
public class BasicQueueProperty {
    private String name;
    private boolean durable;
}
