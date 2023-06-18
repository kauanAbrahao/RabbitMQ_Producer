package rebbitmqproducer.mq.rabbitmq;

import dto.DepartmentDTO;
import dto.DisciplineDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DisciplinePublisher {

    private RabbitTemplate template;

    public void sendMsgWithBean(DisciplineDTO dto) {
        this.template.convertAndSend("amq.direct","disciplineQueueWithBean", dto);
        log.info(String.format("==> RabbitMQ: Sending DTO %s to %s", dto.getIdDisc(), "disQueue2"));
    }


}
