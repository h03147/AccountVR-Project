package com.example.jsondowntest2.demo.dao;


import com.example.jsondowntest2.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    // 注册前先判断该用户名是否已存在
    // (该方法不需要再新建一个service接口，直接在UserServiceImpl的注册方法中调用该方法即可)
    // 学生用学号登录可复用该方法
    public User findBySno(String sno);

    //老师用手机号登录
    public User findByTeacher_Phone(String teacher_phone);

    //人员录入
    public void saveStudentNumber(User user);

    // 查询所有账户
    public List<User> findAll();

    //根据id查询数据
    public User findById(Integer id);

    //更新学生信息表
    public int updateUser(User user);

    //根据id删除学生信息
    public int deleteById(Integer id);
}
