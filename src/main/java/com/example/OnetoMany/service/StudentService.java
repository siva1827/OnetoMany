package com.example.OnetoMany.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnetoMany.Dto.StudentDto;
import com.example.OnetoMany.model.College;
import com.example.OnetoMany.model.Student;
import com.example.OnetoMany.repository.CollegeRepo;
import com.example.OnetoMany.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepo studRepo;

    @Autowired
    private CollegeRepo collegeRepo;


    public StudentDto addStudent(StudentDto studentDto, Long collegeId) {
        College college = collegeRepo.findById(collegeId).orElse(null);
        Student student = modelMapper.map(studentDto,Student.class);
        student.setCollege(college);
        Student saved = studRepo.save(student);
        return modelMapper.map(saved,StudentDto.class);
    }

    public List<StudentDto> findAllStudentByCollegeCid(Long collegeId) {
        List<Student> students = studRepo.findAllStudentByCollegeCid(collegeId);
        List<StudentDto> studentDtos=new ArrayList<>();

        for(Student student:students){
            StudentDto studentDto = new StudentDto();
            studentDto.setSid(student.getSid());
            studentDto.setName(student.getName());
            studentDto.setEmail(student.getEmail());
            studentDtos.add(studentDto);
        }
        return studentDtos;
        //return students.stream()
                // .map(student -> {
                //     StudentDto studentDto = new StudentDto();
                //     studentDto.setSid(student.getSid());
                //     studentDto.setName(student.getName());
                //     studentDto.setEmail(student.getEmail());
                //     return studentDto;
                // })
                // .collect(Collectors.toList());
    }

    public List<List<StudentDto>> findAllCollegesStudent(){
        List<College> colleges = collegeRepo.findAll();
        List<List<StudentDto>> studentList = new ArrayList<>();
        for(College college:colleges){

            List<StudentDto> studentDtos = findAllStudentByCollegeCid(college.getCid());
            studentList.add(studentDtos);
        }
        return studentList;
    }

    // public List<College> findAll(){
    //     List<College> colleges=collegeRepo.findAll();
    //     for(College college:colleges){
    //         List<StudentDto> studentDtos = findAllStudentByCollegeCid(college.getCid());
    //         college.setStudents(studentDtos);
    //     }
    //     return colleges;
    // }

    public List<StudentDto> findStudentsbyCollegeName(String name){
        List<Student> list=studRepo.findAllStudentByCollegeName(name);
        List<StudentDto> studentDtos=list.stream()
            .map(student ->{
                    StudentDto studentDto=new StudentDto();
                    studentDto.setSid(student.getSid());
                    studentDto.setName(student.getName());
                    studentDto.setEmail(student.getEmail());
                    return studentDto;
                }
            )
            .collect(Collectors.toList());
        return studentDtos;
    }

    public String deleteCollege(Long id){
        collegeRepo.deleteById(id);
        return "Deleted Successfully";
    }

    

    

    // Method to convert StudentDto to Student entity
    public Student dtotoEntity(StudentDto studentDto) {
        Student student = new Student();

        // If you are receiving the 'id' from the front end (in the case of updates),
        // set it
        if (studentDto.getSid() != null) {
            student.setSid(studentDto.getSid());
        }

        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());

        return student;
    }

    // Method to convert Student entity to StudentDto
    public StudentDto entityToDto(Student student) {
        StudentDto studentDto = new StudentDto();

        // If the Student entity has an id (which should be generated on save), map it
        studentDto.setSid(student.getSid());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());

        return studentDto;
    }

}
