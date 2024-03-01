package com.example.CollegeDepartment.repository;

import com.example.CollegeDepartment.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Collegerepository extends JpaRepository<College,Long> {
    Optional<College> findByName(String name);
}
