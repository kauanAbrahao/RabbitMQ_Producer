package rebbitmqproducer.mq.service;

import dto.DisciplineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rebbitmqproducer.mq.rabbitmq.DepartmentPublisher;

@Service
public class DisciplineService {

    @Autowired
    DepartmentPublisher publisher;
    public ResponseEntity<?> process(DisciplineDTO dto) {

        //Do some business stuff

        try {
            publisher.sendMsg("disciplineQueue", dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }

    }
}
