package rebbitmqproducer.mq.service;

import dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rebbitmqproducer.mq.rabbitmq.DepartmentPublisher;

@Service
public class DepartmentService {

    @Autowired
    DepartmentPublisher publisher;

    public ResponseEntity<?> process(DepartmentDTO dto){
        //Do some business stuff
        try{
            publisher.sendMsg("departmentQueue", dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    public void processWithBean(DepartmentDTO dto) {
            publisher.sendMsgWithBean(dto);
    }
}
