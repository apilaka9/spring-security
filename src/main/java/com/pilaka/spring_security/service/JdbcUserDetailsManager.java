package com.pilaka.spring_security.service;

import org.jspecify.annotations.Nullable;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;

import java.util.List;

public class JdbcUserDetailsManager extends JdbcDaoImpl implements UserDetailsManager, GroupManager {
private JdbcClient jdbcClient;
    private String updateUserSql =
            "UPDATE users SET password = ?, enabled = ? WHERE username = ?";

    @Override
    public List<String> findAllGroups() {
        return List.of();
    }

    @Override
    public List<String> findUsersInGroup(String groupName) {
        return List.of();
    }

    @Override
    public void createGroup(String groupName, List<GrantedAuthority> authorities) {

    }

    @Override
    public void deleteGroup(String groupName) {

    }

    @Override
    public void renameGroup(String oldName, String newName) {

    }

    @Override
    public void addUserToGroup(String username, String group) {

    }

    @Override
    public void removeUserFromGroup(String username, String groupName) {

    }

    @Override
    public List<GrantedAuthority> findGroupAuthorities(String groupName) {
        return List.of();
    }

    @Override
    public void addGroupAuthority(String groupName, GrantedAuthority authority) {

    }

    @Override
    public void removeGroupAuthority(String groupName, GrantedAuthority authority) {

    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(final UserDetails user) {
       jdbcClient.sql(updateUserSql)
               .param(user.getPassword())
               .param(user.isEnabled())
               .param(user.getUsername())
               .update();

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(@Nullable String oldPassword, @Nullable String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}
