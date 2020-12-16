package com.example.jsondowntest2.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id字段数据库设置了自增就要加这个注解
    private Integer id;
    private String username;
    private String password;
    private String sno;
    private String teacher_phone;
}
