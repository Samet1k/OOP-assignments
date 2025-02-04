package com.example.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schoolmanagement.model.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
}