package com.example.OnetoMany.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnetoMany.Dto.CollegeDto;
import com.example.OnetoMany.model.College;
import com.example.OnetoMany.repository.CollegeRepo;

@Service
public class CollegeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CollegeRepo colRepo;

    public CollegeDto createCollege(CollegeDto collegeDto) {
        // College college=DtotoEntity(collegeDto);
        // College saved=colRepo.save(college);
        // System.out.println("Generated Id is "+college.getCid());
        // return EntityToDto(saved);
        College college=modelMapper.map(collegeDto,College.class);
        College saved=colRepo.save(college);
        return modelMapper.map(saved,CollegeDto.class);
    }

    public List<CollegeDto> getAllColleges() {
        List<College> list=colRepo.findAll();
        return list.stream().map(this::EntityToDto).collect(Collectors.toList());
    }

    // public void deleteAllColleges(){
    //     colRepo.deleteAll();
    // }

    public College DtotoEntity(CollegeDto collegeDto){
        College college=new College();
        college.setName(collegeDto.getName());
        college.setLocation(collegeDto.getLocation());
        return college;
    }

    public CollegeDto EntityToDto(College college){
        CollegeDto collegeDto=new CollegeDto();

        collegeDto.setName(college.getName());
        collegeDto.setLocation(college.getLocation());
        return collegeDto;
    }





}
