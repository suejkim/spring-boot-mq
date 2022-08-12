package com.sjkim.modulemq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("queue")
public class QueueProperty {
    private String name;
    private boolean durable;
}
