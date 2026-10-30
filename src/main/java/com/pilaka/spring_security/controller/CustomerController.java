package com.pilaka.spring_security.controller;


import java.util.UUID;

import com.pilaka.spring_security.model.Customer;
import com.pilaka.spring_security.model.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/customers")
public class CustomerController {



    @Autowired
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // INSERT
    @PostMapping
    public Customer insert(@RequestBody Customer customer) {
        return service.insertCustomer(customer);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Customer update(
            @PathVariable UUID id,
            @RequestBody Customer customer) {

        return service.updateCustomer(id, customer);
    }

    // READ
    @GetMapping("/{id}")
    public Customer get(@PathVariable UUID id) {
        return service.getCustomer(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteCustomer(id);
    }

    // ToDO
//    @GetMapping("/list")
//    public Customer list() {
//        return service.listCustomers;
//    }
}