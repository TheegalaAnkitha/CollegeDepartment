package com.example.CollegeDepartment.controller;

import com.example.CollegeDepartment.model.Department;
import com.example.CollegeDepartment.service.DepartmentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class Departmentcontroller {

    @Autowired
    private DepartmentService departmentservice;

    @PostMapping("/addInCollege/{collegeName}")
    public ResponseEntity<List<Department>> addDepartmentsInCollege(
            @PathVariable String collegeName,
            @RequestBody List<Department> departments
    ) {
        List<Department> addedDepartments = departmentservice.addDepartmentsInCollege(collegeName, departments);
        return ResponseEntity.ok(addedDepartments);
    }

    @GetMapping("/byCollege/{collegeName}")
    public ResponseEntity<List<Department>> getDepartmentsByCollegeName(@PathVariable String collegeName) {
        List<Department> departments = departmentservice.getDepartmentsByCollegeName(collegeName);
        return ResponseEntity.ok(departments);
    }
}

