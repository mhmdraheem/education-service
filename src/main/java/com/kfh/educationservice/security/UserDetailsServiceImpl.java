package com.kfh.educationservice.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl extends InMemoryUserDetailsManager {

    public UserDetailsServiceImpl() {
        super(User.builder()
                        .username("student@mail.com")
                        .password("{bcrypt}$2a$10$ltrMwsyAluK23.bt/FfrtOThoP9CYiqPf1A9f0fFsWuoP6gyg5I0u")
                        .roles("STUDENT")
                        .build(),
                User.builder()
                        .username("instructor@mail.com")
                        .password("{bcrypt}$2a$10$upEmk0UFWyZeLEtz5A7e.eGQZYmpTJfmeUaFZ9LUep7reOmc01Wvq")
                        .roles("INSTRUCTOR")
                        .build(),
                User.builder()
                        .username("admin@mail.com")
                        .password("{bcrypt}$2a$10$i5Roeu929jT.UvTGK0L0nu6bJl/fycATSBlF3XiNFtoOwCn.eYg5e")
                        .roles("ADMIN")
                        .build()
        );
    }
}
