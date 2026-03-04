package com.capgemini.basicsofspringbootmapping.dto;

import com.capgemini.basicsofspringbootmapping.entity.Student;

public class StudentMapper {

    // Convert StudentDto to Student Entity (for create operation)
    public static Student toEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setCollege(studentDto.getCollege());
        student.setMarks(studentDto.getMarks());
        student.setGender(studentDto.getGender());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        return student;
    }

    // Convert Student Entity to StudentDto (for find/response operation)
    public static StudentDto toDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setName(student.getName());
        dto.setCollege(student.getCollege());
        dto.setGender(student.getGender());
        return dto;
    }

}
