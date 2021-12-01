package rebbitmqproducer.mq.controller;

import dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rebbitmqproducer.mq.service.DepartmentService;

@RestController
@RequestMapping(value = "dpt")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @PutMapping
    private ResponseEntity<?> updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        service.processWithBean(departmentDTO);
        return service.process(departmentDTO);
    }
}
