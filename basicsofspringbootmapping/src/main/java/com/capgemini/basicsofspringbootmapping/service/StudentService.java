package com.capgemini.basicsofspringbootmapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.basicsofspringbootmapping.dto.StudentDto;
import com.capgemini.basicsofspringbootmapping.dto.StudentMapper;
import com.capgemini.basicsofspringbootmapping.entity.Student;
import com.capgemini.basicsofspringbootmapping.repository.StudentJpaRepository;

@Service
public class StudentService {

	@Autowired
	StudentJpaRepository jpa;

	// Create a student using DTO
	public StudentDto createStudent(StudentDto studentDto) {
		Student student = StudentMapper.toEntity(studentDto);
		Student savedStudent = jpa.save(student);
		return StudentMapper.toDto(savedStudent);
	}

	// Find a student by ID and return as DTO
	public StudentDto getStudentById(Integer id) {
		Student student = jpa.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		return StudentMapper.toDto(student);
	}

	// Find all students and return as list of DTOs
	public List<StudentDto> getAllStudents() {
		List<Student> students = jpa.findAll();
		return students.stream()
				.map(StudentMapper::toDto)
				.collect(Collectors.toList());
	}

}
