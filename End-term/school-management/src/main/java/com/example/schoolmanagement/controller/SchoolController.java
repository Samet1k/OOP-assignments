package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.School;
import com.example.schoolmanagement.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public List<School> getSchools() {
        return schoolService.getAllSchools();
    }


    @PostMapping
    public School addSchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }
}
