package com.kfh.educationservice.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.Objects;

@Entity
@Table(name = "user_role")
@Getter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role roleName;

    public enum Role {
        ROLE_STUDENT, ROLE_ADMIN
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return roleName == userRole.roleName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }
}
