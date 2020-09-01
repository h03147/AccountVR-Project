package com.example.jsondowntest2.demo.repository;

import com.example.jsondowntest2.demo.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
}
