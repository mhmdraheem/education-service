package com.kfh.educationservice.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.util.Objects;

@Entity
@Table(name = "user")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(nullable = false)
    private String englishName;

    @NotBlank
    @Column(nullable = false)
    private String arabicName;

    @Pattern(regexp="[\\d]")
    @NotBlank
    @Column(nullable = false)
    private String telephone;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @NotNull
    @JoinColumn(name = "role_id")
    @ManyToOne
    private UserRole role;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        STUDENT, INSTRUCTOR, ADMIN
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
