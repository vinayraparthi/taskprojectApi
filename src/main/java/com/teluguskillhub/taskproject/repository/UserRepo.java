package com.teluguskillhub.taskproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teluguskillhub.taskproject.entity.Users;

public interface UserRepo extends JpaRepository<Users, Long>{

  Optional<Users> findByEmail(String email);

}
