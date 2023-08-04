package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.AuthTokenDto;
import com.kfh.educationservice.dto.AuthenticationRequestDto;
import com.kfh.educationservice.dto.UserDto;
import com.kfh.educationservice.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@Valid @RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AuthTokenDto authenticateUser(@Valid @RequestBody AuthenticationRequestDto authenticationRequestDto) {
        return userService.authenticateUser(authenticationRequestDto);
    }
}
