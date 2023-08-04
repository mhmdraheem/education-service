package com.kfh.educationservice.repository.errormessage;

import com.kfh.educationservice.entity.errormessage.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, String> {
}
