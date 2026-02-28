package com.example.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.LibraryBranch;

public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Long> {

}
