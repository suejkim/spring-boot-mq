package com.sjkim.modulemq.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveService {

    // byte array로 받음
//    @RabbitListener(queues = "${queue1.name}")
//    public void receiveMessage(Message message) {
//        log.info("receiveMessage {}", message.toString());
//    }

    // jsonString으로 그대로 받을 수 있음
    @RabbitListener(queues = "${queue1.name}")
    public void receiveString(String message) {
        log.info("{}", message);
    }

    @RabbitListeners(value = {
            @RabbitListener(queues = "${queue2.name1}"),
            @RabbitListener(queues = "${queue2.name2}")
    })
    public void receiveSampleQueue(String message) {
        log.info("{}", message);
    }
}
