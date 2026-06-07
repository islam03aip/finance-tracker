package com.springapp.financetracker.repository;

import com.springapp.financetracker.entity.Spending;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpendingRepository extends CrudRepository<Spending, Integer> {
    List<Spending> findByUserUsername(String username);
    Optional<Spending> findByIdAndUserUsername(Integer id, String username);
}
