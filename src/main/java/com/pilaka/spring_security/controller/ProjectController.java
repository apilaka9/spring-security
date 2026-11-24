package com.pilaka.spring_security.controller;


import com.pilaka.spring_security.model.ProjectRepository;
import com.pilaka.spring_security.model.Projects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    // Constructor injection
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // 1. Insert a project
    @PostMapping
    public ResponseEntity<Projects> createProject(
            @RequestBody Projects projects) {

        Projects savedProject = projectRepository.save(projects);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProject);
    }

    // 2. Retrieve all projects
    @GetMapping
    public List<Projects> getAllProjects() {
        return projectRepository.findAll();
    }

    // 3. Retrieve a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Projects> getProjectById(
            @PathVariable String id) {

        return projectRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



    // 5. Delete a project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(
            @PathVariable String id) {

        if (!projectRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        projectRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}