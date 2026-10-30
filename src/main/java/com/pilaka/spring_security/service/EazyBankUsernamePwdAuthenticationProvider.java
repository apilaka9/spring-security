//package com.pilaka.spring_security.service;
//
//import lombok.RequiredArgsConstructor;
//import org.jspecify.annotations.Nullable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@RequiredArgsConstructor
//public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
//
//   @Autowired
//   private final UserDetailsService userDetailsService;
//   private final PasswordEncoder passwordEncoder;
//
//    public EazyBankUsernamePwdAuthenticationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
//        this.passwordEncoder = passwordEncoder;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    public @Nullable Authentication
//    authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String pwd = authentication.getCredentials().toString();
//        UserDetails userDetails =this.userDetailsService.loadUserByUsername(username);
//        if(passwordEncoder.matches(pwd, userDetails.getPassword())){
//            return new UsernamePasswordAuthenticationToken(username,pwd, userDetails.getAuthorities() );
//        }
//    else{
//        throw new BadCredentialsException("Invalid password");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
//    }
//}
