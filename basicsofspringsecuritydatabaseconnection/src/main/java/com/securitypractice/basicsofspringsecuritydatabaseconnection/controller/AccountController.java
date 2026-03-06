package com.securitypractice.basicsofspringsecuritydatabaseconnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securitypractice.basicsofspringsecuritydatabaseconnection.dto.AccountRequestDTO;
import com.securitypractice.basicsofspringsecuritydatabaseconnection.dto.AccountResponseDTO;
import com.securitypractice.basicsofspringsecuritydatabaseconnection.service.AccountService;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/create")
    public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
        return service.createAccount(dto);
    }
}
