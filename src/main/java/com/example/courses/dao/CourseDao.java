package com.example.courses.dao;

import org.apache.catalina.Manager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courses.model.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {

}

