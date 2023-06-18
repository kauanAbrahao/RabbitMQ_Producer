package rebbitmqproducer.mq.service;

import dto.DisciplineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rebbitmqproducer.mq.rabbitmq.DisciplinePublisher;

@Service
public class DisciplineService {

    @Autowired
    DisciplinePublisher publisher;

    public void processWithBean(DisciplineDTO dto) {
        publisher.sendMsgWithBean(dto);
    }
}
