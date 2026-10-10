package com.pilaka.spring_security.service;

import com.pilaka.spring_security.model.Customer;
import com.pilaka.spring_security.model.CustomerRepository;
import com.pilaka.spring_security.model.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class EazyBankUserDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User not found "+username));
             List<GrantedAuthority> authorities= List.of(new SimpleGrantedAuthority(customer.getRole()));


        return new User(customer.getEmail(), customer.getPwd(), authorities);
    }
}

