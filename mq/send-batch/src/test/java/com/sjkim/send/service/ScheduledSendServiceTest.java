package com.sjkim.send.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjkim.modulemq.dto.QueueDto;
import com.sjkim.modulemq.service.SendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduledSendServiceTest {
    @Autowired
    private SendService sendService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void scheduleMessageTask() {
        QueueDto queueDto = new QueueDto(UUID.randomUUID().toString(), "TEST");
        sendService.sendObject(queueDto);
    }

    @Test
    void scheduleMessageStringTask() throws Exception {
        QueueDto queueDto = new QueueDto(UUID.randomUUID().toString(), "TEST");
        var jsonString = objectMapper.writeValueAsString(queueDto);
        sendService.sendJsonString(jsonString);
    }
}