package com.pilaka.spring_security.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
public class Projects {

    @Id
    private String id;

    private String projectName;
    private String technology;
    private String status;
    private String managerId;

    public Projects() {
    }

    public Projects(String projectName, String technology,
                   String status, String managerId) {
        this.projectName = projectName;
        this.technology = technology;
        this.status = status;
        this.managerId = managerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String manager) {
        this.managerId = manager;
    }
}