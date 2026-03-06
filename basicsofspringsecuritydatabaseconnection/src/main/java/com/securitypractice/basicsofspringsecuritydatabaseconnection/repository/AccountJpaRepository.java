package com.securitypractice.basicsofspringsecuritydatabaseconnection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securitypractice.basicsofspringsecuritydatabaseconnection.entity.Account;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    public Optional<Account> findByUsername(String name);

    public Boolean existsByUsername(String name);

    public Boolean existsByEmail(String email);

}
