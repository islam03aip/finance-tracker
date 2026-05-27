package com.springapp.financetracker.service;

import com.springapp.financetracker.entity.Category;

import java.util.Optional;

public interface CategoryService {
    Iterable<Category> getAllCategory();
    Category createCategory(Category category);
    void updateCategory(Integer categoryId, String name);
    Optional<Category> findCategory(Integer categoryId);
    void deleteCategory(Integer categoryId);
}
