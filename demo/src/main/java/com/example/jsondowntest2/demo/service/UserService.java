package com.example.jsondowntest2.demo.service;

import com.example.jsondowntest2.demo.entity.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {
    // 学生用户登录
    public User login(User user);

    // 教师用户登录
    public User teacherlogin(User user);

    // 人员信息录入
    public void saveStudentNumber(User user);

    // 查询所有账户
    public List<User> findAll();

    // 更新学生信息
    public int updateSingle(User user);

    // 根据id删除学生信息
    public int deletestudentById(Integer id);

    // 验证码键值对生成
    public Map<String, String> saveCaptchaStatus() throws IOException;

    // 验证码的校验
    public Boolean verifyCaptchaStatus(String key, String value);

}