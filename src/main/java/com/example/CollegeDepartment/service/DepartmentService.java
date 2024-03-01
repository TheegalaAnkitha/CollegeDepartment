package com.example.CollegeDepartment.service;

import com.example.CollegeDepartment.model.College;
import com.example.CollegeDepartment.model.Department;
import com.example.CollegeDepartment.repository.Collegerepository;
import com.example.CollegeDepartment.repository.Departmentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private Departmentrepository repo;

    @Autowired
    private Collegerepository collegeRepository;

    public List<Department> addDepartmentsInCollege(String collegeName, List<Department> departments) {
        College college = collegeRepository.findByName(collegeName).orElse(null);

        if (college != null) {
            departments.forEach(department -> department.setCollege(college));
            return repo.saveAll(departments);
        } else {
            return Collections.emptyList();
        }
    }

    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return repo.findByCollegeName(collegeName);
    }


}