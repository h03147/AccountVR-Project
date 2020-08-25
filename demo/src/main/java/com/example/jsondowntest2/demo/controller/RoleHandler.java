package com.example.jsondowntest2.demo.controller;

import com.example.jsondowntest2.demo.entity.Role;
import com.example.jsondowntest2.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleHandler {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/findAll")
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
