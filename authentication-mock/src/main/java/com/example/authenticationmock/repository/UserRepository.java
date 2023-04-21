package com.example.authenticationmock.repository;

import com.example.authenticationmock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
