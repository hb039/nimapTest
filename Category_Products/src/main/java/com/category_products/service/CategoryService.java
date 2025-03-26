package com.category_products.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.category_products.model.Category;
import com.category_products.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable).getContent();
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).orElseThrow();
	}

	public Category updateCategory(int id, Category categoryDetails) {
		Category category = getCategoryById(id);
		category.setName(categoryDetails.getName());
		return categoryRepository.save(category);
	}

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
}
