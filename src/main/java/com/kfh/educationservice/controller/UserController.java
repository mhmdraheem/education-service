package com.kfh.educationservice.controller;

import com.kfh.educationservice.dto.AuthTokenDto;
import com.kfh.educationservice.dto.AuthenticationRequestDto;
import com.kfh.educationservice.dto.UserDto;
import com.kfh.educationservice.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User APIs", description = "A group of public endpoints for managing users registration and authentication")
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Registers a student",
            description = "This API creates new users in the system as students. In a future version, registering instructors and admins will be available")
    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@Valid @RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @Operation(
            summary = "Authenticate a user",
            description = "This API authenticates user's email and password and returns an access token upon success")
    @PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AuthTokenDto authenticateUser(@Valid @RequestBody AuthenticationRequestDto authenticationRequestDto) {
        return userService.authenticateUser(authenticationRequestDto);
    }
}
