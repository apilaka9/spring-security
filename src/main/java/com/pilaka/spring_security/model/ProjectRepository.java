package com.pilaka.spring_security.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository
        extends MongoRepository<Projects, String> {
}