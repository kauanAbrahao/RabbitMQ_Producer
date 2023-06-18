package rebbitmqproducer.mq.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DirectConfig {

    @Autowired
    @Qualifier("depQ")
    Queue depQ;

    @Autowired
    @Qualifier("disQ")
    Queue disQ;

    @Bean
    public DirectExchange directExchange(){
        return ExchangeBuilder
                .directExchange("amq.direct")
                .durable(true)
                .build();
    }

    @Bean
    public Binding bindingDepQ(){
        return BindingBuilder
                .bind(depQ)
                .to(directExchange())
                .with("departmentQueueWithBean");
    }

    @Bean
    public Binding bindingDisQ(){
        return BindingBuilder
                .bind(disQ)
                .to(directExchange())
                .with("disciplineQueueWithBean");
    }

}
