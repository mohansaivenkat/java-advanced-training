package com.securitypractice.basicsofspringsecuritydatabaseconnection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securitypractice.basicsofspringsecuritydatabaseconnection.dto.AccountRequestDTO;
import com.securitypractice.basicsofspringsecuritydatabaseconnection.dto.AccountResponseDTO;
import com.securitypractice.basicsofspringsecuritydatabaseconnection.service.AccountService;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/public")
    public String welcome() {
        return "Welcome to Security Practice App";
    }

    @PostMapping("/create")
    public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
        return service.createAccount(dto);
    }

    @GetMapping("/admin/accounts")
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    @GetMapping("/admin/accounts/{id}")
    public ResponseEntity<AccountResponseDTO> getAccountById(@PathVariable Long id) {
        AccountResponseDTO dto = service.getAccountById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountResponseDTO> getUserAccountById(@PathVariable Long id) {
        AccountResponseDTO dto = service.getAccountById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/accounts/username/{username}")
    public ResponseEntity<AccountResponseDTO> getAccountByUsername(@PathVariable String username) {
        AccountResponseDTO dto = service.getAccountByUsername(username);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/admin/accounts/{id}")
    public ResponseEntity<AccountResponseDTO> updateAccount(@PathVariable Long id, @RequestBody AccountRequestDTO dto) {
        AccountResponseDTO updated = service.updateAccount(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/admin/accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
