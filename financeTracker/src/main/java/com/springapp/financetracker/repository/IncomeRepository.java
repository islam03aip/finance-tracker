package com.springapp.financetracker.repository;

import com.springapp.financetracker.entity.Income;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IncomeRepository extends CrudRepository<Income, Integer> {
    List<Income> findByUserUsername(String username);
    Optional<Income> findByIdAndUserUsername(Integer id, String username);
}
