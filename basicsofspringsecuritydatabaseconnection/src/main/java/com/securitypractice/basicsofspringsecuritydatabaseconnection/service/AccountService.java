package com.securitypractice.basicsofspringsecuritydatabaseconnection.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
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

    public List<AccountResponseDTO> getAllAccounts() {
        List<Account> accounts = jpa.findAll();
        List<AccountResponseDTO> list = new ArrayList<>();
        for (Account a : accounts) {
            list.add(toResponse(a));
        }
        return list;
    }

    @PostAuthorize("returnObject == null or returnObject.username == authentication.name")
    public AccountResponseDTO getAccountById(Long id) {
        Account account = jpa.findById(id).orElse(null);
        if (account == null) {
            return null;
        }
        return toResponse(account);
    }

    public AccountResponseDTO getAccountByUsername(String username) {
        Account account = jpa.findByUsername(username).orElse(null);
        if (account == null) {
            return null;
        }
        return toResponse(account);
    }

    public AccountResponseDTO updateAccount(Long id, AccountRequestDTO dto) {
        Account account = jpa.findById(id).orElse(null);
        if (account == null) {
            return null;
        }
        account.setFullName(dto.getFullName());
        account.setPhone(dto.getPhone());
        account.setEmail(dto.getEmail());
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            account.setPassword(encode.encode(dto.getPassword()));
        }
        if (dto.getRole() != null && !dto.getRole().isEmpty()) {
            account.setRole(normalizeAndValidateRole(dto.getRole()));
        }
        jpa.save(account);
        return toResponse(account);
    }

    public void deleteAccount(Long id) {
        jpa.deleteById(id);
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
