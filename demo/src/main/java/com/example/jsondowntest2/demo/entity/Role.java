package com.example.jsondowntest2.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Role {
    @Id
    private Integer id;
    private String role_name;
    private String role_desc;
}
