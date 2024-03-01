package com.example.CollegeDepartment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "college_id")
    public College college;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    public List<Faculty> faculties;

    @OneToOne
    public Faculty hod;
}
