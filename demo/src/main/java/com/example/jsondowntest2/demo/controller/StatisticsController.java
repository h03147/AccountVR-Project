package com.example.jsondowntest2.demo.controller;

import com.example.jsondowntest2.demo.dao.StatisticsDao;
import com.example.jsondowntest2.demo.entity.Statistics;
import com.example.jsondowntest2.demo.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsRepository statisticsRepository;

    //自定义查询语句用Dao调用
    @Autowired
    private StatisticsDao statisticsDao;

    @GetMapping("/findAll")
    public List<Statistics> findAdd() {
        return statisticsRepository.findAll();
    }

    @GetMapping("/addguestnumber")
    public void statisticsaddone() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        List<Statistics> getBymonth = statisticsDao.findByMonth(String.valueOf(month));
        Statistics statistics = getBymonth.get(0);
        System.out.println("增加前访客数" + statistics.getVisitornumber());
        statistics.setVisitornumber(String.valueOf(Integer.parseInt(statistics.getVisitornumber()) + 1));
        System.out.println("增加后的访客数" + statisticsRepository.save(statistics));
        System.out.println("月份: " + month);
    }
}
