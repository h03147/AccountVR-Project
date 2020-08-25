package com.example.jsondowntest2.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void deleteById() {
        int a = userService.deletestudentById(7);
        System.out.println("这是删除结果：" + a);
    }
}