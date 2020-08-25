package com.example.jsondowntest2.demo.repository;

import com.example.jsondowntest2.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
