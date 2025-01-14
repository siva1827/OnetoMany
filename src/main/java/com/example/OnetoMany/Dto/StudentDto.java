package com.example.OnetoMany.Dto;


public class StudentDto {
    private Long sid;
    public Long getSid() {
        return sid;
    }
    public void setSid(Long sid) {
        this.sid = sid;
    }
    private String name;
    private String email;
     public StudentDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public StudentDto() {}
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
