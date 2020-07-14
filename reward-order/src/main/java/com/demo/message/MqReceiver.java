package com.demo.message;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * Receive mq message
 * 
 * */

@Slf4j
@Component
public class MqReceiver {
	
	//@RabbitListener(queuesToDeclare = @Queue("myQueue"))
	//public void process(String message) {
		//log.info("MqReceiver:{}", message);
	//}
	
}
