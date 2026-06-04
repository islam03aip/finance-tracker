package com.springapp.financetracker.repository;


import com.springapp.financetracker.entity.CustomUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomUserRepository extends CrudRepository<CustomUser, Integer> {
    Optional<CustomUser> findByUsername(String username);
}
