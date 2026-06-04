package com.springapp.financetracker.repository;

import com.springapp.financetracker.entity.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthoritiesRepository extends CrudRepository<Authority, Integer> {
    Optional<Authority> findByAuthority(String authority);
}
