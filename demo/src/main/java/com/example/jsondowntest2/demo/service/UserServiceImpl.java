package com.example.jsondowntest2.demo.service;

import com.example.jsondowntest2.demo.dao.UserDao;
import com.example.jsondowntest2.demo.entity.User;
import com.example.jsondowntest2.demo.util.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    // 初始化一个全局hash
    Map<String, String> All_Captcha_map = new HashMap<>();

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

    // 并发多验证码的生成
    @Override
    public Map<String, String> saveCaptchaStatus() throws IOException {
        // 生成随机键key
        String uuidkey = null;
        UUID getuuidkey = UUID.randomUUID();
        uuidkey = String.valueOf(getuuidkey);
        // 生成随机验证码值value
        Map<String, Object> getImageCode = VerifyUtil.createImageCode();
        // 获取图片验证码对应的值
        String getImageCodeValue = (String) getImageCode.get("code");
        All_Captcha_map.put(uuidkey, getImageCodeValue);
//        System.out.println("这是全部的验证码map：" + All_Captcha_map);

        // 生成验证图片
        BufferedImage image = (BufferedImage) getImageCode.get("image");
        //3.将图片转化为base64
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //5.响应给浏览器  ImageIO ：工具类
        ImageIO.write(image, "png", outputStream);
        String encode = Base64Utils.encodeToString(outputStream.toByteArray());
        // 返回值map创建
        Map<String, String> back_map = new HashMap<>();
        back_map.put("tokenid", uuidkey);
        back_map.put("encode", encode);
        return back_map;
    }

    // 验证码登录校验
    public Boolean verifyCaptchaStatus(String key, String value) {
        if(All_Captcha_map.containsKey(key) == false || key == null || key.length() == 0)
        {
            return false;
        }else {
            String ImageCode1 = All_Captcha_map.get(key);
            if(ImageCode1 == null || ImageCode1.length() == 0)
            {
                return false;
            }else {
                if(value.equalsIgnoreCase(ImageCode1))
                {
//                    System.out.println("key和value都比对成功：");
                    // 比对成功立刻让此验证码失效，释放空间
                    All_Captcha_map.remove(key);
//                    System.out.println("释放后的map：" + All_Captcha_map);
                    return true;
                }else {
//                    System.out.println("value比对失败：");
                    return false;
                }

            }
        }
    }
}
