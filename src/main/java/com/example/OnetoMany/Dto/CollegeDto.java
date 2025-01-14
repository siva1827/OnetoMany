package com.example.OnetoMany.Dto;

public class CollegeDto {
    private Long cid;
    public Long getCid() {
        return cid;
    }
    public void setCid(Long cid) {
        this.cid = cid;
    }
    private String name;
    private String location;

    public CollegeDto(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public CollegeDto(){}
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    

}
