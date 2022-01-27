package br.com.rabbitmq.nessageChannel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Orders {

	@Output
	MessageChannel orders();
	
	@Input
	SubscribableChannel payments();
	
}
