package com.example.jsondowntest2.demo.controller;

import com.example.jsondowntest2.demo.dao.UserDao;
import com.example.jsondowntest2.demo.entity.User;
import com.example.jsondowntest2.demo.repository.StudentreportcardRepository;
import com.example.jsondowntest2.demo.service.UserService;
import com.example.jsondowntest2.demo.util.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private StudentreportcardRepository studentreportcardRepository;


    //学生登录
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        System.out.println("前端传来的user：" + user);
        Map<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);
            map.put("userDB", userDB.getUsername());
            map.put("studentNo", userDB.getSno());
            map.put("state", true);
            map.put("msg", "登录成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    //教师登录
    @PostMapping("/teacherlogin")
    public Map<String, Object> teacherlogin(@RequestBody User user) {
        System.out.println("前段传来的请求user" + user);
        Map<String, Object> map = new HashMap<>();
        try {
            User userDB1 = userService.teacherlogin(user);
            map.put("userDB1", userDB1.getUsername());
            map.put("teacherId", userDB1.getId());
            map.put("state", true);
            map.put("msg", "登录成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    //人员账号录入
    @PostMapping("/addstudentnumber")
    public Map<String, Object> addstudent(@RequestBody User user) {
        System.out.println("前端传来的user：" + user);
        Map<String, Object> map = new HashMap<>();
        try {
            //调用业务方法
            userService.saveStudentNumber(user);
            map.put("state", true);
            map.put("msg", "录入成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());//如果学号已存在会调到catch中注册失败！并返回失败信息
        }
        return map;
    }

    // 对查询所有人员信息前先生成验证码，让前端来请求并校验
    // 生成验证码图片==》响应一个 base64 字符串
    @GetMapping("/getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {
        //1.使用工具类生成验证码(包括image和code)
        Map<String, Object> imageCode = VerifyUtil.createImageCode();
        String code = (String) imageCode.get("code");

        //2.将验证码放入servletContext作用域（前后端分离是没有session概念的）
        request.getServletContext().setAttribute("yCode", code);

        BufferedImage image = (BufferedImage) imageCode.get("image");
        //3.将图片转化为base64
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //5.响应给浏览器  ImageIO ：工具类
        ImageIO.write(image, "png", outputStream);
        String encode = Base64Utils.encodeToString(outputStream.toByteArray());

        return encode;
    }

    // 验证码生成方案2
    // 创建验证码的新键值对
    @GetMapping("/creatNewCaptcha")
    public Map<String, String> creatNewCaptcha() throws IOException{
        Map<String, String> map = new HashMap<>();
        return userService.saveCaptchaStatus();
    }

    //

    //    查询所有人员信息
    @GetMapping("/findAll/{code}")
    public Map<String, Object> findAll(@PathVariable("code") String code, HttpServletRequest request) {
        System.out.println("前端要求：查询所有账户..." + code);
        //拿到当前服务器正确验证码和get请求发来的code比对
        String yCode = (String) request.getServletContext().getAttribute("yCode");
        // 调用service的方法
//        List<User> list = userService.findAll();
//        return String.valueOf(list);
        Map<String, Object> map = new HashMap<>();

        if(yCode.equalsIgnoreCase(code))
            {
               List<User> list = userService.findAll();
                map.put("list", list);
                map.put("state", true);
            }else
            {
                map.put("state", false);
            }
            return map;
    }

    // 登录界面比对验证码
    @GetMapping("/SigninIdentityCodeImage/{code}")
    public String SigninIdentityCodeImage(@PathVariable("code") String code, HttpServletRequest request) {
        System.out.println("前端进行登录验证码请求：" + code);
        String yCode = (String) request.getServletContext().getAttribute("yCode");
        System.out.println("这是后端需要比对的验证码" + yCode);

        if(yCode.equalsIgnoreCase(code))
        {
            return "true";
        }else
        {
            return "验证码错误";
        }

    }

    // 登陆界面对比验证码方式2
    // 校验验证码
    @GetMapping("/verifyImageCode/{tokenid}/{ImageCode}")
    public Boolean verifyImageCode(
            @PathVariable("tokenid") String tokenid,
            @PathVariable("ImageCode") String ImageCode) {
        return userService.verifyCaptchaStatus(tokenid, ImageCode);
    }


    @Autowired
    private UserDao userDao;
//    根据id获取数据
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        System.out.println("前端传来了消息" + id);
        User SingleUser = userDao.findById(id);
        System.out.println("后端即将返回的数据" + SingleUser);
        return SingleUser;
    }

    //修改学生信息
    @PostMapping("/updateSingle")
    public int updateSingle(@RequestBody  User user) {
        System.out.println("前端要请求了！"+user);
        int state = userService.updateSingle(user);
        return state;
    }

    //根据id删除学生信息
    @DeleteMapping("/deleteByUserId/{id}")
    public int deletestudentById(@PathVariable("id") Integer id) {
        System.out.println("前端传来根据id删除的请求" + id);
        return userService.deletestudentById(id);
    }

//    // 创建验证码的新键值对
//    @GetMapping("/creatNewCaptcha")
//    public String creatNewCaptcha() {
//        return userService.saveCaptchaStatus();
//    }
//
//    // 校验验证码
//    @GetMapping("/verifyImageCode/{tokenid}/{ImageCode}")
//    public Boolean verifyImageCode(
//            @PathVariable("tokenid") String tokenid,
//            @PathVariable("ImageCode") String ImageCode) {
//        return userService.verifyCaptchaStatus(tokenid, ImageCode);
//    }


}
