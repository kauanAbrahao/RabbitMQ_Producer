package rebbitmqproducer.mq.service;


import dto.CreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rebbitmqproducer.mq.rabbitmq.CreatePublisher;

@Service
public class CreateService {
    @Autowired
    CreatePublisher publisher;

    public void process(CreateDTO dto) {
        publisher.publish(dto);
    }
}
