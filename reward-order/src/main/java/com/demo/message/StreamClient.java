package com.demo.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
	String INPUT = "myMessage";
	
	SubscribableChannel input();
	
	@Output("myMessage")
	MessageChannel output();
}
