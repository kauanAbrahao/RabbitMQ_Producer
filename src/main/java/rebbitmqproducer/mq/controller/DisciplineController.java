package rebbitmqproducer.mq.controller;

import dto.DisciplineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rebbitmqproducer.mq.service.DisciplineService;

@RestController
@RequestMapping(value = "disc")
public class DisciplineController {

    @Autowired
    DisciplineService service;

    @PutMapping
    private ResponseEntity<HttpStatus> updateDiscipline(@RequestBody DisciplineDTO disciplineDTO){
        service.processWithBean(disciplineDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
