package com.pilaka.spring_security.model;


import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;



public interface CustomerRepository
        extends CassandraRepository<Customer, UUID> {
}