package rebbitmqproducer.mq.rabbitmq;

import dto.CreateDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class CreatePublisher {

    RabbitTemplate template;

    public void publish(CreateDTO dto){
        template.convertAndSend("amq.fanout", "", dto);
        log.info(String.format("==> RabbitMQ: Sending CreateDTO dep = %s dis = %s to whoever wants to get it", dto.getDepartment().getNameDpt(),dto.getDiscipline().getNameDisc()));
    }

}
