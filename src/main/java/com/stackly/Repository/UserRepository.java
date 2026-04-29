package com.stackly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}