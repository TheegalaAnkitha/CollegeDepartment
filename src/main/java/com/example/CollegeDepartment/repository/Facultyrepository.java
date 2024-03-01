package com.example.CollegeDepartment.repository;

import com.example.CollegeDepartment.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Facultyrepository extends JpaRepository<Faculty, Long> {
    List<Faculty>findByDepartmentCollegeName(String collegeName);

    List<Faculty>findByDepartmentName(String departmentName);
}



