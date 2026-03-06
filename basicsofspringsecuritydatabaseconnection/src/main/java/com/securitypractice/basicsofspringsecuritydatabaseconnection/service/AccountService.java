package com.securitypractice.basicsofspringsecuritydatabaseconnection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securitypractice.basicsofspringsecuritydatabaseconnection.dto.AccountRequestDTO;
import com.securitypractice.basicsofspringsecuritydatabaseconnection.dto.AccountResponseDTO;
import com.securitypractice.basicsofspringsecuritydatabaseconnection.entity.Account;
import com.securitypractice.basicsofspringsecuritydatabaseconnection.repository.AccountJpaRepository;

@Service
public class AccountService {

    @Autowired
    private AccountJpaRepository jpa;

    @Autowired
    private PasswordEncoder encode;

    public AccountResponseDTO createAccount(AccountRequestDTO dto) {
        if (jpa.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("User Name Exists");
        }
        if (jpa.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("User Email Exists");
        }

        Account account = new Account();
        account.setUsername(dto.getUsername());
        account.setFullName(dto.getFullName());
        account.setPassword(encode.encode(dto.getPassword()));
        account.setPhone(dto.getPhone());
        account.setEmail(dto.getEmail());
        account.setCreatedAt(dto.getCreatedAt());
        account.setRole(normalizeAndValidateRole(dto.getRole()));

        jpa.save(account);

        return toResponse(account);

    }

    public String normalizeAndValidateRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            return "ROLE_USER";
        }

        String r = role.trim().toUpperCase();

        if (!r.startsWith("ROLE_")) {
            r = "ROLE_" + r;
        }
        if (!r.equalsIgnoreCase("ROLE_USER") && !r.equalsIgnoreCase("ROLE_ADMIN")) {
            throw new RuntimeException("Role Not Found");
        }

        return r;
    }

    public AccountResponseDTO toResponse(Account a) {

        AccountResponseDTO dto = new AccountResponseDTO();

        dto.setEmail(a.getEmail());
        dto.setPhone(a.getPhone());
        dto.setFullname(a.getFullName());
        dto.setUsername(a.getUsername());

        return dto;
    }

}
