package com.sjkim.send.service;

import com.sjkim.modulemq.service.SendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledSendService {
    private final SendService sendService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduleMessageTask() {
        log.info("----------");
    }
}