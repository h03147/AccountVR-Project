package com.example.jsondowntest2.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Studentreportcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id字段数据库设置了自增就要加这个注解
    private Integer id;
    private String sno;
    private String examstatus;
    private String examgrade;
    private String spendtime;
}
