
package com.pilaka.spring_security.config;

import com.pilaka.spring_security.model.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

public final CustomerRepository customerRepository;

    public ProjectSecurityConfig(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
                        .authenticated()
                        .requestMatchers("/notice", "/contact", "/error","/register" )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
               .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService(){
        UserDetails user = User.withUsername(("user"))  .password(passwordEncoder().encode("admin")).authorities("read").build();
        UserDetails admin = User.withUsername(("admin"))  .password(passwordEncoder().encode("admin")).authorities("update").build();
        return new InMemoryUserDetailsManager(user,admin);
    }
   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}