package com.spring.boot.products.api.category.services.impl;

import com.spring.boot.products.api.category.entities.Category;
import com.spring.boot.products.api.category.repositories.CategoryRepository;
import com.spring.boot.products.api.category.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryId(UUID id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category updateCategory(Category category, UUID id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with ID" + id + "not found")
        );
        existingCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(existingCategory);
        return existingCategory;
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with ID" + id + "not found"));

        categoryRepository.deleteById(id);

    }
}
