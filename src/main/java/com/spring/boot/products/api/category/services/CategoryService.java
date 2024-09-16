package com.spring.boot.products.api.category.services;

import com.spring.boot.products.api.category.entities.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAllCategories();

    Optional<Category> getCategoryId(UUID id);

    Category updateCategory(Category category, UUID id);

    void deleteCategory(UUID id);
}
