package com.example.courses.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.courses.model.*;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

}


