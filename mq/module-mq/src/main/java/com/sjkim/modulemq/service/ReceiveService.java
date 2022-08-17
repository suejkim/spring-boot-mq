package com.sjkim.modulemq.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveService {

//    @RabbitListener(queues = "${queue.name}")
//    public void receiveMessage(Message message) {
//        log.info("receiveMessage {}", message.toString());
//    }

//    @RabbitListener(queues = "${queue.name}")
//    public void receiveString(String message) {
//        log.info("{}", message);
//    }
}
