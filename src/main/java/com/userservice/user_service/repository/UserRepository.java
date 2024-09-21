package com.userservice.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.userservice.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // No need to define any methods here, Spring Data JPA will automatically create them for us
    }