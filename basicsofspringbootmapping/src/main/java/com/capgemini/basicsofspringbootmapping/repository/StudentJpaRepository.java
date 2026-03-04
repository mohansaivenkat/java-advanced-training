package com.capgemini.basicsofspringbootmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.basicsofspringbootmapping.entity.Student;

public interface StudentJpaRepository extends JpaRepository<Student, Integer>{

}
