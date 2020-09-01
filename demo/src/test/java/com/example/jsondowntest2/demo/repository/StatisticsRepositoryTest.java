package com.example.jsondowntest2.demo.repository;

import com.example.jsondowntest2.demo.dao.StatisticsDao;
import com.example.jsondowntest2.demo.entity.Statistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatisticsRepositoryTest {

    @Autowired
    private StatisticsRepository statisticsRepository;

    //自定义查询语句用Dao调用
    @Autowired
    private StatisticsDao statisticsDao;

    @Test
    void findAdd() {
        System.out.println(statisticsRepository.findAll());
    }

    @Test
    void findcalendar() {
        Calendar cal = Calendar.getInstance();
//        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
//        int year = cal.get(Calendar.YEAR);
//        int dow = cal.get(Calendar.DAY_OF_WEEK);
//        int dom = cal.get(Calendar.DAY_OF_MONTH);
//        int doy = cal.get(Calendar.DAY_OF_YEAR);
//        System.out.println("日期: " + day);
        List<Statistics> getBymonth = statisticsDao.findByMonth(String.valueOf(month));
        Statistics statistics = getBymonth.get(0);
        System.out.println("增加前访客数" + statistics.getVisitornumber());
        statistics.setVisitornumber(String.valueOf(Integer.parseInt(statistics.getVisitornumber()) + 1));
        System.out.println("增加后的访客数" + statisticsRepository.save(statistics));
        System.out.println("月份: " + month);

    }
}