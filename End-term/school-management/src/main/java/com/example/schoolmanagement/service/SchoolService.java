package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.School;
import com.example.schoolmanagement.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository repository;

    public List<School> getAllSchools() {
        return repository.findAll();
    }

    public School addSchool(School school) {
        return repository.save(school);
    }
}
