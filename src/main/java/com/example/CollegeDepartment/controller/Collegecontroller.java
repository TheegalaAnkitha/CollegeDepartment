package com.example.CollegeDepartment.controller;

import com.example.CollegeDepartment.model.College;
import com.example.CollegeDepartment.service.Collegeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class Collegecontroller {

    @Autowired
    private Collegeservice collegeservice;

    @PostMapping("/add")
    public ResponseEntity<College> addCollege(@RequestBody College college) {
        College addedCollege = collegeservice.addCollege(college);
        return ResponseEntity.ok(addedCollege);
    }

    @GetMapping("/list")
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = collegeservice.getAllColleges();
        return ResponseEntity.ok(colleges);
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        return collegeservice.getCollegeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<College> getCollegeByName(@PathVariable String name) {
        return collegeservice.getCollegeByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}/{newName}")
    public ResponseEntity<College> updateCollegeName(@PathVariable Long id, @PathVariable String newName) {
        return collegeservice.updateCollegeName(id, newName).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCollegeById(@PathVariable Long id) {
        collegeservice.deleteCollegeById(id);
        return ResponseEntity.ok().build();
    }
}

