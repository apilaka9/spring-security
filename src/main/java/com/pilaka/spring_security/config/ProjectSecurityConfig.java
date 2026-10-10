package com.pilaka.spring_security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
                        .authenticated()
                        .requestMatchers("/notice", "/contact", "/error", "/myAccount","/register" )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(flc->flc.disable())

                .httpBasic(withDefaults());


        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService(){
        UserDetails user = User.withUsername(("user")).password("{noop}user").authorities("read").build();
        UserDetails admin = User.withUsername(("admin")).password( "{noop}admin").authorities("update").build();
        return new InMemoryUserDetailsManager(user,admin);
    }
   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}