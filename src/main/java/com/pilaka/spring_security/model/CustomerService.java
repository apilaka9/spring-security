package com.pilaka.spring_security.model;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // INSERT
    public Customer insertCustomer(Customer customer) {

        if (customer.getId() == null) {
            customer.setId(UUID.randomUUID());
        }

        return repository.save(customer);
    }

    // UPDATE
    public Customer updateCustomer(
            UUID id, Customer updatedCustomer) {

        Customer existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found: " + id));

        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());
        existing.setCity(updatedCustomer.getCity());

        return repository.save(existing);
    }

    // READ
    public Customer getCustomer(UUID id) {
        return repository.findById(id).orElse(null);
    }

    // DELETE
    public void deleteCustomer(UUID id) {
        repository.deleteById(id);
    }
}

