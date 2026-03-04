package com.capgemini.basicsofrediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.basicsofrediscache.entity.FileData;

public interface FileDataJpaRepository extends JpaRepository<FileData, Integer>{

}
