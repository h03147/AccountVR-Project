package com.example.jsondowntest2.demo.dao;

import com.example.jsondowntest2.demo.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatisticsDao extends JpaRepository<Statistics, Integer> {

    //根据月份查询信息
    public List<Statistics> findByMonth(String month);

//    //根据月份修改访问量
//    public int saveByMonth(String month);
}
