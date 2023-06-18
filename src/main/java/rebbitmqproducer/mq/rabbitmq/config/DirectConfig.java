package rebbitmqproducer.mq.rabbitmq.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.GenericWebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration

public class DirectConfig {

    //private final GenericWebApplicationContext context;
//    private final List<Queue> filas;
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
    public Binding binding(){
        return BindingBuilder
                .bind(depQ)
                .to(directExchange())
                .with("departmentQueueWithBean");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder
                .bind(disQ)
                .to(directExchange())
                .with("disciplineQueueWithBean");
    }

//    @PostConstruct
//    public void biding(){
//        filas.forEach(
//            queue -> {
//                context.registerBean(
//                        queue.getName(),
//                        Binding.class,
//                        () -> BindingBuilder
//                                .bind(queue)
//                                .to(directExchange())
//                                .with(queue.getName())
//                );
//            }
//        );
//    }
}
