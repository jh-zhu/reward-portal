package com.demo.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {
	
	@StreamListener(value = StreamClient.INPUT)
	public void process(Object message) {
		log.info("StreamReceiver: {}",message);
	}
	
	
}
