package com.sjkim.send.service;

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

    @Test
    void scheduleMessageTask() {
        QueueDto queueDto = new QueueDto(UUID.randomUUID().toString(), "TEST");
        sendService.sendObject(queueDto);
    }
}