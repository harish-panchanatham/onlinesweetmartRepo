package com.cg.onlinesweetmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinesweetmart.entity.Category;
import com.cg.onlinesweetmart.repository.CategoryRepository;
import com.cg.onlinesweetmart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryService;

	public Category addCategory(Category category) {
		return categoryService.save(category);
		
	}

	public List<Category> showAllCategory() {
		return categoryService.findAll();
	}

	public Category updateCategory(Category category) {
		return categoryService.save(category);
	}

	public void cancelCategory(int categoryId) {
		categoryService.deleteById(categoryId);
	}

	public Category showCategory(int categoryId) {
		return categoryService.findById(categoryId).get();
	}
}
