package com.sjkim.modulemq.service;

import com.sjkim.modulemq.config.QueueProperty;
import com.sjkim.modulemq.dto.QueueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendService {
    private final RabbitTemplate rabbitTemplate;
    private final QueueProperty queueProperty;

    public boolean sendObject(QueueDto queueDto) {
        rabbitTemplate.convertAndSend(queueProperty.getName(), queueDto);
        return true;
    }

    public boolean sendJsonString(String queueJsonString) {
        rabbitTemplate.convertAndSend(queueProperty.getName(), queueJsonString);
        return true;
    }
}
