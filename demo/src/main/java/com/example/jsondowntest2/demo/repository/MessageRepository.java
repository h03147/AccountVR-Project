package com.example.jsondowntest2.demo.repository;

import com.example.jsondowntest2.demo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
