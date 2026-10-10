package com.pilaka.spring_security.controller;

import com.pilaka.spring_security.model.Customer;
import com.pilaka.spring_security.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserController(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }
@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){

          System.out.println("Registering user");
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            Customer savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("User saved ");
            }
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR )
                    .body("An Exception occurred "+ex.getMessage());
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body("saved");
    }


}
