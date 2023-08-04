package com.kfh.educationservice.repository.user;

import com.kfh.educationservice.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.role where u.email=:email")
    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email);
}
