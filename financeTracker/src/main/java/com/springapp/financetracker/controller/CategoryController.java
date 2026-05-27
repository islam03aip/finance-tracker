package com.springapp.financetracker.controller;

import com.springapp.financetracker.controller.payload.UpdateCategoryPayload;
import com.springapp.financetracker.entity.Category;
import com.springapp.financetracker.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    public Iterable<Category> getAllCategories(){
        return this.categoryService.getAllCategory();
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category){
        return this.categoryService.createCategory(category);
    }

    @PostMapping("/update/{categoryId:\\d+}")
    public void updateCategory(@PathVariable("categoryId") Integer categoryId, UpdateCategoryPayload payload){
        this.categoryService.updateCategory(categoryId, payload.name());
    }

    @PostMapping("/delete/{categoryId:\\d+}")
    public void deleteCategory(@PathVariable("categoryId") Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/{categoryId:\\d+}")
    public Optional<Category> findCategory(@PathVariable("categoryId") Integer categoryId){
        return this.categoryService.findCategory(categoryId);
    }
}
