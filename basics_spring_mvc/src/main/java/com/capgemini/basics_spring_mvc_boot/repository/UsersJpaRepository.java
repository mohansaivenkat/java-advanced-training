package com.capgemini.basics_spring_mvc_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.basics_spring_mvc_boot.model.Users;

public interface UsersJpaRepository extends JpaRepository<Users, Integer>{

}
