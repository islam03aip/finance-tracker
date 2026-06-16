package com.springapp.financetracker.repository;

import com.springapp.financetracker.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {

}
