package com.sjkim.send;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SendBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendBatchApplication.class, args);
    }

}
