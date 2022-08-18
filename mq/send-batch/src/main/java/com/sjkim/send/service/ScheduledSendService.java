package com.sjkim.send.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjkim.modulemq.dto.QueueDto;
import com.sjkim.modulemq.service.SendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledSendService {
    private final SendService sendService;
    private final ObjectMapper objectMapper;

    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduleMessageTask() {
        log.info("----------");
        QueueDto queueDto = new QueueDto(UUID.randomUUID().toString(), "TEST");
        sendService.sendObject(queueDto);
    }


    public void scheduleMessageStringTask() throws JsonProcessingException {
        log.info("==========");
        QueueDto queueDto = new QueueDto(UUID.randomUUID().toString(), "TEST");
        var jsonString = objectMapper.writeValueAsString(queueDto);
        sendService.sendJsonString(jsonString);
    }
}
