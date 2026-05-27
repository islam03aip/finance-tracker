package com.springapp.financetracker.service;

import com.springapp.financetracker.entity.Category;
import com.springapp.financetracker.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> getAllCategory(){
        return this.categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category createCategory(Category category){
        return this.categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void updateCategory(Integer categoryId, String name){
        this.categoryRepository.findById(categoryId)
                .ifPresentOrElse(category -> {
                    category.setName(name);
                }, () -> {
                    throw new NoSuchElementException();
        });
    }

    @Override
    public Optional<Category> findCategory(Integer categoryId){
        return this.categoryRepository.findById(categoryId);
    }

    @Override
    @Transactional
    public void deleteCategory(Integer categoryId){
        this.categoryRepository.deleteById(categoryId);
    }
}
