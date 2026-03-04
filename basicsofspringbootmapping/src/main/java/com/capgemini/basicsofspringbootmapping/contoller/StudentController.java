package com.capgemini.basicsofspringbootmapping.contoller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.basicsofspringbootmapping.dto.StudentDto;
import com.capgemini.basicsofspringbootmapping.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	// Create a student using DTO
	@PostMapping("/create")
	public StudentDto addStudent(@Valid @RequestBody StudentDto studentDto) {
		return service.createStudent(studentDto);
	}

	// Find a student by ID - returns DTO
	@GetMapping("/find/{id}")
	public StudentDto getStudentById(@PathVariable Integer id) {
		return service.getStudentById(id);
	}

	// Find all students - returns list of DTOs
	@GetMapping("/findAll")
	public List<StudentDto> getAllStudents() {
		return service.getAllStudents();
	}

}
