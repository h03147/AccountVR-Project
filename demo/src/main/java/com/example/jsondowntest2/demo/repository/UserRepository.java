package com.example.jsondowntest2.demo.repository;


import com.example.jsondowntest2.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
