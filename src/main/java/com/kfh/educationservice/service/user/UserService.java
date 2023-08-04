package com.kfh.educationservice.service.user;

import com.kfh.educationservice.common.exception.type.DuplicateAccountException;
import com.kfh.educationservice.common.exception.type.UserNotFoundException;
import com.kfh.educationservice.common.jwt.JwtService;
import com.kfh.educationservice.dto.AuthTokenDto;
import com.kfh.educationservice.dto.AuthenticationRequestDto;
import com.kfh.educationservice.dto.UserDto;
import com.kfh.educationservice.entity.user.User;
import com.kfh.educationservice.entity.user.UserRole;
import com.kfh.educationservice.repository.user.UserRepository;
import com.kfh.educationservice.repository.user.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Transactional
    public UserDto registerUser(UserDto userDto) {
        validateUserDoesNotExists(userDto);
        User user = populatedUserEntity(new User(), userDto);
        userRepository.save(user);
        return userEntityToStudentDto(user);
    }

    private void validateUserDoesNotExists(UserDto userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())) {
            throw new DuplicateAccountException(userDto.getEmail());
        }
    }

    private User populatedUserEntity(User user, UserDto userDto) {
        user.setEmail(userDto.getEmail());

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encodedPassword);
        user.setEnglishName(userDto.getEnglishName());
        user.setArabicName(userDto.getArabicName());
        user.setTelephone(userDto.getTelephone());
        user.setAddress(userDto.getAddress());

        // TODO: allow for different roles other than ROLE_STUDENT
        UserRole studentRole = userRoleRepository.findByRoleName(UserRole.Role.ROLE_STUDENT);
        user.setRole(studentRole);
        return user;
    }

    private UserDto userEntityToStudentDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setEnglishName(user.getEnglishName());
        userDto.setArabicName(user.getArabicName());
        userDto.setTelephone(user.getTelephone());
        userDto.setAddress(user.getAddress());
        return userDto;
    }

    public AuthTokenDto authenticateUser(AuthenticationRequestDto authenticationRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequestDto.getEmail(),
                        authenticationRequestDto.getPassword())
        );

        String token = jwtService.createToken(authenticationRequestDto.getEmail());
        return new AuthTokenDto(token);
    }

    public void validateUserExists(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new UserNotFoundException(String.valueOf(userId));
        }
    }
}
