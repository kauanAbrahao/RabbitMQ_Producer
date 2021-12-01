package rebbitmqproducer.mq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String NAME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){this.amqpAdmin = amqpAdmin;}

    private Queue queue(String qName){
        return new Queue(qName, true, false, false);
    }

    private DirectExchange directExchange(){
        return new DirectExchange(NAME_EXCHANGE);
    }

    private Binding relationship(Queue queue, DirectExchange directExchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void add(){
        Queue departmentQueue = this.queue("departmentQueue");
        Queue disciplineQueue = this.queue("disciplineQueue");

        DirectExchange directExchange = this.directExchange();

        Binding bindingDpt = this.relationship(departmentQueue, directExchange);
        Binding bindingDisc = this.relationship(disciplineQueue, directExchange);

        this.amqpAdmin.declareQueue(departmentQueue);
        this.amqpAdmin.declareQueue(disciplineQueue);
        this.amqpAdmin.declareExchange(directExchange);
        this.amqpAdmin.declareBinding(bindingDpt);
        this.amqpAdmin.declareBinding(bindingDisc);
    }
}
