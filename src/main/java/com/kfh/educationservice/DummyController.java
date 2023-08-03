package com.kfh.educationservice;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DummyController {

    @Secured({"ROLE_STUDENT"})
    @GetMapping("/student")
    public String helloStudent() {
        return "Hello Student";
    }

    @Secured({"ROLE_INSTRUCTOR"})
    @GetMapping("/instructor")
    public String helloInstructor() {
        return "Hello instructor";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello admin";
    }

    @PostMapping("/register")
    public String register() {
        return "registration";
    }

    @PostMapping("/authenticate")
    public String authenticate() {
        return "authentication";
    }
}
