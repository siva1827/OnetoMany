package com.example.OnetoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OnetoMany.model.College;

public interface CollegeRepo extends JpaRepository<College, Long> {


}
