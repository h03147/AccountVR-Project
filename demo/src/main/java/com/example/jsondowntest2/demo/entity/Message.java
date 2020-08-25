package com.example.jsondowntest2.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id字段数据库设置了自增就要加这个注解
    private Integer id;
    private String student_name;
    private String teacher_name;
    private String question;
    private String answer;
    private String request_time;
    private String response_time;
}
