package com.pilaka.spring_security;

import com.pilaka.spring_security.model.Customer;
import com.pilaka.spring_security.model.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan("com.pilaka.spring_security")
@EnableJpaRepositories("com.pilaka.spring_security")
//com.pilaka.spring_security.controller
//@EnableWebSecurity
public class EazyBankBackendApplication {
CustomerService customerService;



	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
