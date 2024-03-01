package com.example.CollegeDepartment.controller;

import com.example.CollegeDepartment.model.Faculty;
import com.example.CollegeDepartment.service.Facultyservice;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class Facultycontroller {

    @Autowired
    private Facultyservice facultyService;



    @GetMapping("/{collegeName}")
    public List<Faculty> getFacultiesInCollege(@PathVariable String collegeName) {
        return facultyService.getFacultiesInCollege(collegeName);
    }

    @PostMapping("/{departmentId}")
    public List<Faculty> assignFacultiesToDepartment(
            @PathVariable Long departmentId,
            @RequestBody List<Long> facultyIds
    ) {
        return facultyService.assignFacultiesToDepartment(departmentId, facultyIds);
    }

    @PostMapping("/{departmentId}/{facultyId}")
    public void assignHodToDepartment(
            @PathVariable Long departmentId,
            @PathVariable Long facultyId
    ) {
        facultyService.assignHodToDepartment(departmentId, facultyId);
    }

    @GetMapping("/{departmentName}")
    public List<Faculty> getFacultiesByDepartmentName(@PathVariable String departmentName) {
        return facultyService.getFacultiesByDepartmentName(departmentName);
    }

    @GetMapping("/{departmentId}")
    public String getHodNameByDepartmentId(@PathVariable Long departmentId) {
        return facultyService.getHodNameByDepartmentId(departmentId);
    }
}

