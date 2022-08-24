package com.sjkim.modulemq.service;

import com.sjkim.modulemq.dto.QueueDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SendServiceTest {
    @Autowired
    private SendService sendService;

    @Test
    void sendSampleOneQueue() {
        boolean result = sendService.sendSampleOneQueue(new QueueDto("sample", "one"));
        assertThat(result, Matchers.is(true));
    }
}