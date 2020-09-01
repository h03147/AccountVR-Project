package com.example.jsondowntest2.demo.controller;

import com.example.jsondowntest2.demo.dao.StudentreportcardDao;
import com.example.jsondowntest2.demo.entity.Message;
import com.example.jsondowntest2.demo.entity.Studentreportcard;
import com.example.jsondowntest2.demo.repository.StudentreportcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/studentreportcard")
public class StudentreportcardController {

    @Autowired
    private StudentreportcardRepository studentreportcardRepository;

    @Autowired
    private StudentreportcardDao studentreportcardDao;

    @GetMapping("/findAllstudentreportcard")
    public List<Studentreportcard> findAllstudentreportcard() {
        return studentreportcardRepository.findAll();
    }

    //考试概况分数统计
    @GetMapping("/studentcount")
    public Map<String, Object> studentcount() {
        List<Studentreportcard> stulist = studentreportcardRepository.findAll();
        Map<String, Object> map = new HashMap<>();
        int particinumber = stulist.size(); //参与人数
        int completednumber = 0; //完成考试的人数
        int passnumber = 0;//及格人数
        double passrate = 0.0; //及格率
        Studentreportcard sturc = new Studentreportcard();
        sturc = stulist.get(0);
        String longesttime = sturc.getSpendtime(); //用时最长
        String shortesttime = sturc.getSpendtime(); //用时最短
        int totaltime = 0; //总时长
        double averagetime = 0; //平均时长
        double completedrate = 0.0; //已提交率
        double unsubmittedrate = 0.0; //未提交率
        int totalscore = 0; //总分
        double averagescore = 0; //平均分
        String maxscore = sturc.getExamgrade(); //最高分
        String minscore = sturc.getExamgrade(); //最低分
        String passscore = "60"; //及格分
        int nlevel90100 = 0; //90-100分人数
        int nlevel8089 = 0; //90-100分人数
        int nlevel7079 = 0; //90-100分人数
        int nlevel6069 = 0; //60-69分人数
        int nlevel0059 = 0; //00-59分人数
        double level90100 = 0.0; //90-100分率
        double level8089 = 0.0; //90-100分率
        double level7079 = 0.0; //90-100分率
        double level6069 = 0.0; //60-69分率
        double level0059 = 0.0; //00-59分率

        for(int i =0; i < stulist.size(); i++)
        {
            sturc = stulist.get(i);
//            System.out.println("sturc"+sturc.getExamstatus());
            //字符串中可能会有非数字注意抛异常
            try {
                if(Integer.parseInt(sturc.getExamgrade()) > 0 && Integer.parseInt(sturc.getSpendtime()) > 0)
                {
                    if(sturc.getExamstatus().equals("1"))
                    {
                        completednumber++;
                        totaltime += Integer.parseInt(sturc.getSpendtime());
                        totalscore += Integer.parseInt(sturc.getExamgrade());
                    }
                    if(Integer.parseInt(sturc.getExamgrade()) >= 60)
                    {
                        passnumber++;
                    }

                    if(longesttime.compareTo(sturc.getSpendtime()) < 0)
                    {
                        longesttime = sturc.getSpendtime();
                    }

                    if(shortesttime.compareTo(sturc.getSpendtime()) > 0)
                    {
                        shortesttime = sturc.getSpendtime();
                    }

                    if(maxscore.compareTo(sturc.getExamgrade()) < 0)
                    {
                        maxscore = sturc.getExamgrade();
                    }

                    if(minscore.compareTo(sturc.getExamgrade()) > 0)
                    {
                        minscore = sturc.getExamgrade();
                    }

                    if (Integer.parseInt(sturc.getExamgrade()) > 100) {
                        //输入无效的成绩直接跳出方法
                        System.out.println("请输入有效的成绩");
//                    return map;
                    }else if (Integer.parseInt(sturc.getExamgrade())>=90) {
                        nlevel90100++;
                    } else if(Integer.parseInt(sturc.getExamgrade())>=80) {
                        nlevel8089++;
                    }else if(Integer.parseInt(sturc.getExamgrade())>=70) {
                        nlevel7079++;
                    }else if(Integer.parseInt(sturc.getExamgrade())>=60) {
                        nlevel6069++;
                    }else {
                        nlevel0059++;
                    }
                }

            } catch (NumberFormatException e) {
//                e.printStackTrace();
                System.out.println("数据库有非数字字符串转换为整型失败");
            }
        }
        passrate = (passnumber/(completednumber * 1.0)) * 100;
        averagetime = totaltime/(completednumber * 1.0);
        completedrate = completednumber/(particinumber * 1.0);
        unsubmittedrate = 1.0 - completedrate;
        averagescore = totalscore/(completednumber *1.0);


        //考试概况
        List<String> sturesultlist1 = new ArrayList<>();
        sturesultlist1.add(String.valueOf(particinumber));
        sturesultlist1.add(String.valueOf(completednumber));
        sturesultlist1.add(String.valueOf(String.format("%.2f", passrate)));
        sturesultlist1.add(longesttime);
        sturesultlist1.add(shortesttime);
        sturesultlist1.add(String.valueOf(String.format("%.0f", averagetime)));
        map.put("sturesultlist1", sturesultlist1);

        //分数统计
        List<String> sturesultlist2 = new ArrayList<>();
        level90100 = nlevel90100/(completednumber *1.0) * 100;
        level8089 = nlevel8089/(completednumber *1.0) * 100;
        level7079 = nlevel7079/(completednumber *1.0) * 100;
        level6069 = nlevel6069/(completednumber *1.0) * 100;
        level0059 = nlevel0059/(completednumber *1.0) * 100;
        sturesultlist2.add(String.valueOf(String.format("%.2f", level90100)));
        sturesultlist2.add(String.valueOf(String.format("%.2f", level8089)));
        sturesultlist2.add(String.valueOf(String.format("%.2f", level7079)));
        sturesultlist2.add(String.valueOf(String.format("%.2f", level6069)));
        sturesultlist2.add(String.valueOf(String.format("%.2f", level0059)));
        map.put("sturesultlist2", sturesultlist2);

        //平均分最高分最低分及格分及格率
        List<String> sturesultlist3 = new ArrayList<>();
        averagescore = totalscore/(completednumber * 1.0);
        sturesultlist3.add(String.valueOf(String.format("%.0f", averagescore)));
        sturesultlist3.add(maxscore);
        sturesultlist3.add(minscore);
        sturesultlist3.add(passscore);
        sturesultlist3.add(String.valueOf(String.format("%.2f", passrate)));
        map.put("sturesultlist3", sturesultlist3);

        //总时长平均时长
        List<String> sturesultlist4 = new ArrayList<>();
        sturesultlist4.add(String.valueOf(String.format("%.0f", averagetime)));
        sturesultlist4.add(String.valueOf(totaltime));
        map.put("sturesultlist4", sturesultlist4);

        //已提交未提交人数
        List<Integer> sturesultlist5 = new ArrayList<>();
        sturesultlist5.add(completednumber);
        sturesultlist5.add(particinumber - completednumber);
        map.put("sturesultlist5", sturesultlist5);


        return map;
    }

    //接受unity回传的成绩单修改请求
    @PutMapping("/update")
    public String update(@RequestBody Studentreportcard studentreportcard){
//        前端传过来的修改留言请求
        System.out.println("前段unity传来的请求成绩单"+studentreportcard);
        String getsno = studentreportcard.getSno();
//        studentreportcardRepository.
        List<Studentreportcard> sturesultBySno = studentreportcardDao.findBySno(getsno);
        Studentreportcard savestufinish = sturesultBySno.get(0);
        savestufinish.setSno(studentreportcard.getSno());
        savestufinish.setExamstatus(studentreportcard.getExamstatus());
        savestufinish.setExamgrade(studentreportcard.getExamgrade());
        savestufinish.setSpendtime(studentreportcard.getSpendtime());

        Studentreportcard result = studentreportcardRepository.save(savestufinish);
        if(result != null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }

    //    添加默认学生信息
    @PostMapping("/addstudentrepotcard")
    public String addstudentrepotcard(@RequestBody Studentreportcard studentreportcard){
        //        前端传过来的修改留言请求
        System.out.println("前段传来的请求user"+studentreportcard);
//        message.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        message.setAnswer("未答复");
//        Message addmessageresult = messageRepository.save(message);
        studentreportcard.setExamstatus("2");
        studentreportcard.setExamgrade("-1");
        studentreportcard.setSpendtime("-1");
        Studentreportcard addstudentresult =studentreportcardRepository.save(studentreportcard);
        if(addstudentresult != null)
        {
            return "add student success!";
        }else
        {
            return "add student failed!";
        }
    }
}
