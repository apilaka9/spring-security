package com.pilaka.spring_security.controller;

import com.pilaka.spring_security.model.Customer;
import com.pilaka.spring_security.model.CustomerRepository;
import com.pilaka.spring_security.model.Employee;
import com.pilaka.spring_security.model.MysqlEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private final MysqlEmployeeRepository employeeRepository;

    public EmployeeController(MysqlEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> registerUser(@RequestBody Employee employee){
          System.out.println("creating Employee Record");
            Employee savedEmployee = employeeRepository.save(employee);
            if (savedEmployee.getEmp_id() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("record saved ");
            }
        return  ResponseEntity.status(HttpStatus.CREATED).body("saved");
    }
    @GetMapping("/list")
    public List<Employee> list(){
       return employeeRepository.findAll();

    }

}
