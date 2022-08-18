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
        // payload: {"index":"4e6281fe-38b2-4e31-892e-657cc734ad8f","name":"TEST"}
        return true;
    }

    public boolean sendJsonString(String queueJsonString) {
        rabbitTemplate.convertAndSend(queueProperty.getName(), queueJsonString);
        // 문자열로 queue로 들어가기 때문에 \가 포함됨
        // payload: {\"index\":\"6cb240f0-604d-4339-a489-d74e0e745242\",\"name\":\"TEST\"}"
        return true;
    }
}
