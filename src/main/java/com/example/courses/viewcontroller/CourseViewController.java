package com.example.courses.viewcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.controller.CourseController;
import com.example.courses.model.*;
import com.example.courses.springutils.SpringUtils;;

@RestController
@RequestMapping("/course")
public class CourseViewController {
	
	private CourseController courseController;
	
	    
	 // Get All Notes
		@CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("/list")
	    public List<Course> getAllCourses() {
	    	courseController = (CourseController)SpringUtils.ctx.getBean(CourseController.class);
	    	
	        return courseController.listAll();
	    }

	    // Create a new Note
		@CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/insert")
	    public Course createCourse(@Valid @RequestBody Course course) {
	    	courseController = (CourseController)SpringUtils.ctx.getBean(CourseController.class);
	        return courseController.insert(course);
	    }
	    
	    // Get a Single Note
		@CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("/get/{id}")
	    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Long courseId) {
	        Course fcourse = new Course();
	        courseController = (CourseController)SpringUtils.ctx.getBean(CourseController.class);
	        
	        fcourse.setId(courseId);
	    	Course course = courseController.getCourse(fcourse);
	        if(course == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(course);
	    }
	    
	    // Update a Note
		@CrossOrigin(origins = "http://localhost:4200")
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long courseId, 
	                                           @Valid @RequestBody Course course) {
	    	courseController = (CourseController)SpringUtils.ctx.getBean(CourseController.class);
	    	Course updatedCourse = courseController.update(course);
	        if(updatedCourse == null) {
	            return ResponseEntity.notFound().build();
	        }
	       
	        return ResponseEntity.ok(updatedCourse);
	    }

	    // Delete a Note	
		@CrossOrigin(origins = "http://localhost:4200")
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Course> deleteNote(@PathVariable(value = "id") Long courseId) {
	    	courseController = (CourseController)SpringUtils.ctx.getBean(CourseController.class);
	    	Course course = new Course();
	        course.setId(courseId);
	    	Course deletedCourse = courseController.delete(course);
	        
	        if(deletedCourse == null) {
	            return ResponseEntity.notFound().build();
	        }

	        return ResponseEntity.ok().build();
	    }

}
