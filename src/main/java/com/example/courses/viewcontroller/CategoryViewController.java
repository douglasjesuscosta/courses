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

import com.example.courses.controller.CategoryController;
import com.example.courses.model.Category;
import com.example.courses.springutils.SpringUtils;


@RestController
@RequestMapping("/api")
public class CategoryViewController {
	
	CategoryController categoryController;
	
	// Get All Notes
	@GetMapping("/category")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Category> getAllCategory() {
		categoryController = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);

		return categoryController.listAll();
	}

	// Create a new Note
	
	@PostMapping("/category")
	@CrossOrigin(origins = "http://localhost:4200")
	public Category createCategory(@Valid @RequestBody Category category) {
		categoryController = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
		return categoryController.insert(category);
	}

	// Get a Single Note
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long categoryId) {
		Category fcategory= new Category();
		categoryController = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
		fcategory.setId(categoryId);
		
		fcategory = categoryController.getCategory(fcategory);
		if (fcategory == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(fcategory);
	}

	// Update a Note
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId,
			@Valid @RequestBody Category category) {
		categoryController = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
		Category updatedCourse = categoryController.update(category);
		if (updatedCourse == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(updatedCourse);
	}

	// Delete a Note
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/category/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable(value = "id") Long categoryId) {
		categoryController = (CategoryController) SpringUtils.ctx.getBean(CategoryController.class);
		Category category = new Category();
		category.setId(categoryId);
		Category deletedCategory = categoryController.delete(category);

		if (deletedCategory == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().build();
	}

}
