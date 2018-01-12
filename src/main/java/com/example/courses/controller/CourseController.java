package com.example.courses.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.courses.dao.CourseDao;
import com.example.courses.model.Course;
import com.example.courses.model.Model;

@Configurable
@Service
public class CourseController {
	//
	@Autowired
	CourseDao courseDao;
	
	public boolean isPersisted(Course course) {
		Course fCourse= courseDao.findOne(course.getId());
	    if(course == null) {
	        return false;
	    }
	    return true;
		
	}
	
	public Course getCourse(Course course) {
		return courseDao.findOne(course.getId());
	}

	public Course insert(Course course) {
		return courseDao.save(course);

	}

	public Course update(Course course) {
		
	    if(!isPersisted(course)) {
	        return null;
	    }
		return courseDao.save(course);

	}

	public Course delete(Course course) {

		if (!isPersisted(course)) {
			return null;
		}
		courseDao.delete(course);
		return course;

	}

	public List<Course> listAll() {
		return courseDao.findAll();

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
