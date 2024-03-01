package com.example.CollegeDepartment.service;

import com.example.CollegeDepartment.model.Department;
import com.example.CollegeDepartment.model.Faculty;
import com.example.CollegeDepartment.repository.Departmentrepository;
import com.example.CollegeDepartment.repository.Facultyrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class Facultyservice {

    @Autowired
    private Facultyrepository facultyRepository;

    @Autowired
    private Departmentrepository departmentrepository;

    public List<Faculty> addFacultiesInCollege(String collegeName, List<Faculty> faculties) {
        // Assuming each faculty object has a reference to the department
        // If not, you may need to set the department for each faculty before saving

        // Add additional business logic if needed
        return facultyRepository.saveAll(faculties);
    }

    public List<Faculty> getFacultiesInCollege(String collegeName) {
        return facultyRepository.findByDepartmentCollegeName(collegeName);
    }

    public List<Faculty> assignFacultiesToDepartment(Long departmentId, List<Long> facultyIds) {
        Optional<Department> optionalDepartment = departmentrepository.findById(departmentId);

        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            List<Faculty> faculties = facultyRepository.findAllById(facultyIds);
            faculties.forEach(faculty -> faculty.setDepartment(department));
            // Add additional business logic if needed
            return facultyRepository.saveAll(faculties);
        } else {
            // Handle the case where the department is not found
            return Collections.emptyList();
        }
    }

    public void assignHodToDepartment(Long departmentId, Long facultyId) {
        Optional<Department> optionalDepartment = departmentrepository.findById(departmentId);
        Optional<Faculty> optionalFaculty = facultyRepository.findById(facultyId);

        if (optionalDepartment.isPresent() && optionalFaculty.isPresent()) {
            Department department = optionalDepartment.get();
            Faculty faculty = optionalFaculty.get();
            department.setHod(faculty);
            // Add additional business logic if needed
            departmentrepository.save(department);
        } else {
            // Handle the case where the department or faculty is not found
        }
    }

    public List<Faculty> getFacultiesByDepartmentName(String departmentName) {
        return facultyRepository.findByDepartmentName(departmentName);
    }

    public String getHodNameByDepartmentId(Long departmentId) {
        Optional<Department> optionalDepartment = departmentrepository.findById(departmentId);

        if (optionalDepartment.isPresent()) {
            Faculty hod = optionalDepartment.get().getHod();
            return (hod != null) ? hod.getName() : "No HOD assigned";
        } else {
            // Handle the case where the department is not found
            return "Department not found";
        }
    }
}



