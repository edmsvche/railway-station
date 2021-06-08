package com.example.railwaystation.repository;

import com.example.railwaystation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    //User findByEmail(String email);
}

