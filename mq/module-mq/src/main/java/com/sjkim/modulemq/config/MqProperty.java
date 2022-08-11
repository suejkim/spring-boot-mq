package com.sjkim.modulemq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("rabbitmq")
public class MqProperty {
    private String host;
    private int port;
    private String username;
    private String password;
}
