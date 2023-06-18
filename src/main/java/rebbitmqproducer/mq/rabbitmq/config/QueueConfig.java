package rebbitmqproducer.mq.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean(value = "depQ")
    public Queue depQueue(){
        return QueueBuilder
                .durable("departmentQueueWithBean")
                .build();
    }
    @Bean(value = "disQ")
    public Queue dicQueue(){
        return QueueBuilder
                .durable("disciplineQueueWithBean")
                .build();
    }

}
