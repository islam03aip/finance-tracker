package com.springapp.financetracker.repository;

import com.springapp.financetracker.entity.Income;
import org.springframework.data.repository.CrudRepository;

public interface IncomeRepository extends CrudRepository<Income, Integer> {
}
