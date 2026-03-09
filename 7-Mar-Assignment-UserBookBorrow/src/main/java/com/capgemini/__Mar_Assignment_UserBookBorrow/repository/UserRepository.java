package com.capgemini.__Mar_Assignment_UserBookBorrow.repository;

import com.capgemini.__Mar_Assignment_UserBookBorrow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
