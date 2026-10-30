//package com.pilaka.spring_security.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.jspecify.annotations.Nullable;
//import org.springframework.security.core.CredentialsContainer;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import jakarta.persistence.Id;
////import org.springframework.security.core.CredentialsContainer;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@Entity
//@Setter
//@Getter
//
//public class User implements UserDetails, CredentialsContainer {
//    public User(String email, String pwd, List<GrantedAuthority> authorities) {
//    }
//    @Override
//    public void eraseCredentials() {
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//    @Override
//    public @Nullable String getPassword() {
//        return "";
//    }
//
//
//    public String getUsername() {
//        return "";
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
//    }
//    @Override
//    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
//    }
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
//    }
//    @Override
//    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
//    }
//    @Id
//    @Column(nullable = false, unique = true, length = 50)
//    public String email;
//
//
//}