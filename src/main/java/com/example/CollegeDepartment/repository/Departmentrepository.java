package com.example.CollegeDepartment.repository;

import com.example.CollegeDepartment.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Departmentrepository extends JpaRepository<Department,Long> {
    List<Department>findByCollegeName(String collegeName);


}
