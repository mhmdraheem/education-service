package com.kfh.educationservice.service.student;

import com.kfh.educationservice.common.exception.type.DuplicateAccountException;
import com.kfh.educationservice.dto.StudentDto;
import com.kfh.educationservice.entity.user.User;
import com.kfh.educationservice.entity.user.UserRole;
import com.kfh.educationservice.repository.user.UserRepository;
import com.kfh.educationservice.repository.user.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Transactional
    public StudentDto registerStudent(StudentDto studentDto) {
        validateStudentDoesNotExists(studentDto);
        User user = populatedUserEntity(new User(), studentDto);
        userRepository.save(user);
        return userEntityToStudentDto(user);
    }

    private void validateStudentDoesNotExists(StudentDto studentDto) {
        if(userRepository.existsByEmail(studentDto.getEmail())) {
            throw new DuplicateAccountException(studentDto.getEmail());
        }
    }

    private User populatedUserEntity(User user, StudentDto studentDto) {
        user.setEmail(studentDto.getEmail());

        String encodedPassword = passwordEncoder.encode(studentDto.getPassword());
        user.setPassword(encodedPassword);
        user.setEnglishName(studentDto.getEnglishName());
        user.setArabicName(studentDto.getArabicName());
        user.setTelephone(studentDto.getTelephone());
        user.setAddress(studentDto.getAddress());

        UserRole studentRole = userRoleRepository.findByRoleName(UserRole.Role.ROLE_STUDENT);
        user.setRole(studentRole);
        return user;
    }
    
    private StudentDto userEntityToStudentDto(User user) {
        StudentDto studentDto = new StudentDto();
        studentDto.setEmail(user.getEmail());
        studentDto.setEnglishName(user.getEnglishName());
        studentDto.setArabicName(user.getArabicName());
        studentDto.setTelephone(user.getTelephone());
        studentDto.setAddress(user.getAddress());
        return studentDto;
    }
}
