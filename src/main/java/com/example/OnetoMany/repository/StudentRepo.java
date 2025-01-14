package com.example.OnetoMany.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.OnetoMany.model.Student;


public interface StudentRepo extends JpaRepository<Student,Long> {

    List<Student> findAllStudentByCollegeCid(Long collegeId);

    //List<Student> findAllStudentByCollegeName(String name);

    List<Student> findAllStudentByCollegeName(String name);

    



}
