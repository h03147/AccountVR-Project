package com.example.jsondowntest2.demo.repository;

import com.example.jsondowntest2.demo.dao.StudentreportcardDao;
import com.example.jsondowntest2.demo.entity.Studentreportcard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SpringBootTest
class StudentreportcardRepositoryTest {

    @Autowired
    private StudentreportcardRepository studentreportcardRepository;

    @Autowired
    private StudentreportcardDao studentreportcardDao;

    @Test
    void findAll(){
        System.out.println(studentreportcardRepository.findAll());
    }

    @Test
    public void studentcount() {
        List<Studentreportcard> stulist = studentreportcardRepository.findAll();
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
                    return;
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

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        passrate = (passnumber/(completednumber * 1.0)) * 100;
        averagetime = totaltime/(completednumber * 1.0);
        completedrate = completednumber/(particinumber * 1.0);
        unsubmittedrate = 1.0 - completedrate;
        averagescore = totalscore/(completednumber *1.0);
        List<Integer> stalist1 = new ArrayList<>();
        stalist1.add(particinumber);
        stalist1.add(completednumber);
        stalist1.add(passnumber);

//        System.out.println("stalist1："+stalist1);

//        System.out.println("参与人数："+particinumber);
//        System.out.println("完成人数："+completednumber);
//        System.out.println("及格人数："+passnumber);
//        System.out.println("及格率："+String.format("%.2f",passrate)+"%");
//        System.out.println("用时最长："+longesttime);
//        System.out.println("用时最短："+shortesttime);
//        System.out.println("总时长："+totaltime);
//        System.out.println("平均时长："+String.format("%.0f",averagetime));
//        System.out.println("已提交率："+String.format("%.2f",completedrate * 100)+"%");
//        System.out.println("未提交率："+String.format("%.2f",unsubmittedrate * 100)+"%");
//        System.out.println("平均分："+String.format("%.0f",averagescore));
//        System.out.println("最高分："+maxscore);
//        System.out.println("最低分："+minscore);
//        System.out.println("90-100："+String.format("%.2f",(nlevel90100/(completednumber *1.0)) *100)+"%");
//        System.out.println("80-89："+String.format("%.2f",(nlevel8089/(completednumber *1.0)) *100)+"%");
//        System.out.println("70-79："+String.format("%.2f",(nlevel7079/(completednumber *1.0)) *100)+"%");
//        System.out.println("60-69："+String.format("%.2f",(nlevel6069/(completednumber *1.0)) *100)+"%");
//        System.out.println("00-59："+String.format("%.2f",(nlevel0059/(completednumber *1.0)) *100)+"%");

//        Map<String, Object> map = new HashMap<>();
//        map.put("a", stulist);
//        return map;
    }

    @Test
    void findBysno() {
        System.out.println(studentreportcardDao.findBySno("10008"));
    }


}