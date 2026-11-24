package com.pilaka.spring_security;



import com.pilaka.spring_security.model.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.pilaka.spring_security")
@EnableJpaRepositories("com.pilaka.spring_security")

public class EazyBankBackendApplication {
CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
