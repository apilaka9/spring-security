package com.pilaka.spring_security.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_id;
    @Column(name ="name")
    private String name;
    @Column(name ="email")
    private String email;
    @Column(name="hiredate")
    private Date hire_date;
}
