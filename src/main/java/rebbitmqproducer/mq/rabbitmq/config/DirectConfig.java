package rebbitmqproducer.mq.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    @Autowired
    Queue depQueue;

    @Bean
    public DirectExchange directExchange(){
        return ExchangeBuilder
                .directExchange("amq.direct")
                .durable(true)
                .build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(depQueue)
                .to(directExchange())
                .with("departmentQueueWithBean");
    }
}
