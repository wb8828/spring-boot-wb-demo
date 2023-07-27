package com.spring.demo.login.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.equals(username, "wb")) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
                "wb",
                "$2a$10$bc1h96SQuF6faHaJSg3p6.9tpHMF61OxlZZeyZU22NPTvhnv4nQkW",
                true,
                true,
                true,
                true,
                AuthorityUtils.createAuthorityList("USER")
        );
    }
}