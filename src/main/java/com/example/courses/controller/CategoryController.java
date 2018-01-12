package com.example.courses.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.courses.dao.CategoryDao;
import com.example.courses.model.Category;
import com.example.courses.model.Course;
import com.example.courses.model.Model;

@Configurable
@Service
public class CategoryController {
	//
	@Autowired
	CategoryDao categoryDao;
	
	public boolean isPersisted(Category category) {
		Category fcategory= categoryDao.findOne(category.getId());
	    if(category == null) {
	        return false;
	    }
	    return true;
		
	}
	
	public Category getCategory(Category category) {
		return categoryDao.findOne(category.getId());
	}

	public Category insert(Category category) {
		return categoryDao.save(category);

	}

	public Category update(Category category) {
		
	    if(!isPersisted(category)) {
	        return null;
	    }
		return categoryDao.save(category);

	}

	public Category delete(Category category) {

//		if (isPersisted(category)) {
//			return null;
//		}
		categoryDao.delete(category);
		return category;

	}

	public List<Category> listAll() {
		return categoryDao.findAll();

	}
	
	

	// @Override
	// public Model getTableObject() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public List listAllModel() {
	// CourseDao courseDao = new CourseDao();
	// ArrayList<Course> courseList = courseDao.listAll();
	// return courseList;
	// }
	//
	// @Override
	// public Model getModel(Model model) {
	// CourseDao courseDao = new CourseDao();
	// Course course = courseDao.getCourse((Course) model);
	// return course;
	// }

}
