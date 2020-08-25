package com.example.jsondowntest2.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String sno;
    private String teacher_phone;
}
