package com.example.jsondowntest2.demo.service;

import com.example.jsondowntest2.demo.dao.UserDao;
import com.example.jsondowntest2.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        //1.根据前端输入的学生学号，判断用户是否已存在
        User userBySno = userDao.findBySno(user.getSno());
        //或 if (!ObjectUtils.isEmpty(userByName))  对象不为空
        if (userBySno!=null){
            //用户存在，比对密码
            if (userBySno.getPassword().equals(user.getPassword())){
                return userBySno;
            }else {
//                throw new RuntimeException("密码不正确！");
                throw new RuntimeException("用户名或密码不正确！");
            }
        }else {
//            throw new RuntimeException("学号不存在！");
            throw new RuntimeException("用户名或密码不正确！");
        }
    }

    @Override
    public User teacherlogin(User user) {
        //1.根据手机号判断教师用户是否存在
        User userByTeacher_Phone = userDao.findByTeacher_Phone(user.getTeacher_phone());
        if(userByTeacher_Phone != null)
        {
            //手机号存在，进一步比对密码
            if(userByTeacher_Phone.getPassword().equals(user.getPassword()))
            {
                return userByTeacher_Phone;
            }else
            {
//                throw new RuntimeException("密码不正确！");
                throw new RuntimeException("用户名或密码不正确！");
            }
        }else
        {
//            throw new RuntimeException("教师账号不存在！");
            throw new RuntimeException("用户名或密码不正确！");
        }
    }

    @Override
    public void saveStudentNumber(User user) {
        //判断学号是否已经添加过了
        User bySon= userDao.findBySno(user.getSno());
        if(bySon == null)
        {
            userDao.saveStudentNumber(user);
        }else
        {
            throw new RuntimeException("学号已存在！");
        }
    }

    public List<User> findAll() {
        System.out.println("业务层：查询所有账户...");
        return userDao.findAll();
    }

    @Override
    public int updateSingle(User user) {
        //修改学生信息
        int SingleUserResult = userDao.updateUser(user);
        return SingleUserResult;
    }

    @Override
    public int deletestudentById(Integer id) {
        int deleteResult = userDao.deleteById(id);
        return deleteResult;
    }
}
