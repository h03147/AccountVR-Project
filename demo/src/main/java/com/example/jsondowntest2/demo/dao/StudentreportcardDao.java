package com.example.jsondowntest2.demo.dao;

import com.example.jsondowntest2.demo.entity.Studentreportcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentreportcardDao extends JpaRepository<Studentreportcard, Integer> {
    //通过反射在Jpa底层拼接sql语句
    public List<Studentreportcard> findBySno(String sno);
}
