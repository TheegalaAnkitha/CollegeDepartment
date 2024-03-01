package com.example.CollegeDepartment.service;


import com.example.CollegeDepartment.model.College;
import com.example.CollegeDepartment.repository.Collegerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Collegeservice {

    @Autowired
    private Collegerepository repo;

    public College addCollege(College college) {
        return repo.save(college);
    }

    public List<College> getAllColleges() {
        return repo.findAll();
    }

    public Optional<College> getCollegeById(Long id) {
        return repo.findById(id);
    }

    public Optional<College> getCollegeByName(String name) {
        return repo.findByName(name);
    }

    public Optional<College> updateCollegeName(Long id, String newName) {
        return repo.findById(id)
                .map(college -> {
                    college.setName(newName);
                    // Add additional business logic if needed
                    return repo.save(college);
                });
    }

    public void deleteCollegeById(Long id) {
        repo.deleteById(id);
    }
}
