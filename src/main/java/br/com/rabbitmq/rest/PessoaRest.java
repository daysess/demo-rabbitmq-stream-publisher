package br.com.rabbitmq.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rabbitmq.model.Pessoa;

@RestController
@RequestMapping("/pessoas")
public class PessoaRest {

	@Autowired
	private Source source;
	
	@Autowired
	@Qualifier("orders")
	private MessageChannel orders;

	@PostMapping
	public void publishMessage(@RequestBody Pessoa pessoa){
		source.output().send(MessageBuilder.withPayload(pessoa).setHeader("x-correlationId", "123456").build());
	}
	
	@PostMapping("/orders")
	public void publishMessagetoOrders(@RequestBody Pessoa pessoa){
		orders.send(MessageBuilder.withPayload(pessoa).setHeader("x-correlationId", "999999").build());
	}
	
}
