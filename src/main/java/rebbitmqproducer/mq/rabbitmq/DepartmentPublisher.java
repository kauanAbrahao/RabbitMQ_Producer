package rebbitmqproducer.mq.rabbitmq;

import dto.DepartmentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DepartmentPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String qName, Object msg){
        log.info(String.format("==> RabbitMQ: Sending msg %s to %s", msg.toString(), qName));
        this.rabbitTemplate.convertAndSend(qName, msg);

    }

    public void sendMsgWithBean(DepartmentDTO dto) {
        this.rabbitTemplate.convertAndSend("amq.direct","departmentQueueWithBean", dto.getCodDpt());
        log.info(String.format("==> RabbitMQ: Sending DTO %s to %s", dto.getCodDpt(), "depQueue2"));
    }
}
