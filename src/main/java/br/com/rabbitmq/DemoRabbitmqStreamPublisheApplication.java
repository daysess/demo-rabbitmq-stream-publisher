package br.com.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;

import br.com.rabbitmq.model.Pessoa;
import br.com.rabbitmq.nessageChannel.Orders;

@EnableBinding({ Source.class, Orders.class })
@SpringBootApplication
public class DemoRabbitmqStreamPublisheApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRabbitmqStreamPublisheApplication.class, args);
	}
	
	@StreamListener("payments")
	public void handleMessage(Pessoa pessoa){
		System.out.println("pessoa " + pessoa);
	}

}
