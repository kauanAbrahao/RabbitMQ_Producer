package rebbitmqproducer.mq.controller;

import dto.CreateDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rebbitmqproducer.mq.service.CreateService;

@RestController
@RequestMapping(value = "registration")
@AllArgsConstructor
public class CreateController {

    @Autowired
    CreateService service;

    @PostMapping
    private ResponseEntity<HttpStatus> createDepDis(@RequestBody CreateDTO createDTO){
        service.process(createDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
