package com.example.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
