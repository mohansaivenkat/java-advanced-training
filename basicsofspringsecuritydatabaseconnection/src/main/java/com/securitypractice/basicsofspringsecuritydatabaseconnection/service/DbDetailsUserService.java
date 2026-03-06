package com.securitypractice.basicsofspringsecuritydatabaseconnection.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitypractice.basicsofspringsecuritydatabaseconnection.entity.Account;
import com.securitypractice.basicsofspringsecuritydatabaseconnection.repository.AccountJpaRepository;

@Service
public class DbDetailsUserService implements UserDetailsService {

    @Autowired
    private AccountJpaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username Not Found: " + username));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(account.getRole()));

        return new User(account.getUsername(), account.getPassword(), authorities);
    }

}
