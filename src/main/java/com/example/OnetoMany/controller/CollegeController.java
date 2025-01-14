package com.example.OnetoMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnetoMany.Dto.CollegeDto;
import com.example.OnetoMany.Dto.StudentDto;
import com.example.OnetoMany.model.College;
import com.example.OnetoMany.model.Student;
import com.example.OnetoMany.model.Student;
import com.example.OnetoMany.repository.StudentRepo;
import com.example.OnetoMany.service.CollegeService;
import com.example.OnetoMany.service.StudentService;
import com.example.OnetoMany.service.StudentService;

@RestController
@RequestMapping("/College")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/createCollege")
    public CollegeDto createCollege(@RequestBody CollegeDto collegeDto) {
        return collegeService.createCollege(collegeDto);
    }

    @PostMapping("/addStudent")
    public StudentDto createStudent(@RequestBody StudentDto student, @RequestParam Long collegeId) {
        return studentService.addStudent(student, collegeId);
    }

    // @GetMapping("/getAll")
    // public ResponseEntity<List<List<StudentDto>>> findAllCollegesStudent(){
    //     return new ResponseEntity<>(studentService.findAllCollegesStudent(),HttpStatus.CREATED);
    // }

    @GetMapping("/getAll")
    public List<List<StudentDto>> findAllCollegesStudent(){
        return studentService.findAllCollegesStudent();
    }

    @GetMapping("/getByName/{name}")
    public List<StudentDto> getStudentByCollegeName(@PathVariable String name) {
        return studentService.findStudentsbyCollegeName(name);
    }
    
        
    @DeleteMapping("/delete")
    public String deleteCollege(@PathVariable Long id){
        return studentService.deleteCollege(id);
    }    
    
    
    @GetMapping("/studentByCId")
    public List<StudentDto> getStudByColId(@RequestParam Long collegeId){
        return studentService.findAllStudentByCollegeCid(collegeId);
    }

    // @DeleteMapping("/deleteCollege")
    // public String deleteAllCollege(){
    //     studentService.deleteAllStudents();
    //     return "All Colleges and Students deleted";
        
    // }

    // @GetMapping("/getAllStudents")
    // public ResponseEntity<List<College>> getAllStudents(){
    //     return new ResponseEntity<>(studentService.findAll(),HttpStatus.OK);
    // }





}
