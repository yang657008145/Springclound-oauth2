package com.yrz.serviceauth.repository;


import com.yrz.serviceauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
