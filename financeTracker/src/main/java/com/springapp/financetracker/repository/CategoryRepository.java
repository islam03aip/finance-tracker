package com.springapp.financetracker.repository;

import com.springapp.financetracker.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
