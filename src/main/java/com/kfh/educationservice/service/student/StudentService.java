package com.kfh.educationservice.service.student;

import com.kfh.educationservice.dto.UserDto;
import com.kfh.educationservice.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final UserService userService;

    @Transactional
    public UserDto registerStudent(UserDto userDto) {
        return userService.registerUser(userDto);
    }
}
