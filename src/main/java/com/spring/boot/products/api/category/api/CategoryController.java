package com.spring.boot.products.api.category.api;

import com.spring.boot.products.api.category.entities.Category;
import com.spring.boot.products.api.category.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/categories")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable("id") UUID id) {
        Optional<Category> category = categoryService.getCategoryId(id);
        return ResponseEntity.ok(category);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable("id") UUID id,
                                                      @RequestBody Category category) {
        categoryService.updateCategory(category, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }
}
