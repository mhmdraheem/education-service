package com.kfh.educationservice.common.exception.handler;

import com.kfh.educationservice.common.exception.type.BusinessException;
import com.kfh.educationservice.dto.ErrorDto;
import com.kfh.educationservice.service.errormessage.ErrorMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ErrorMessageService errorMessageService;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleGenericError(Exception ex) {
        log.error("Exception {} has been caught", ex.getClass().getSimpleName(), ex);
        return createErrorResponse(ex);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleAccessDeniedError(Exception ex) {
        log.error("Exception {} has been caught", ex.getClass().getSimpleName(), ex);
    }

    private ErrorDto createErrorResponse(Exception ex) {
        String errorCode = ex.getClass().getSimpleName();
        String errorMessage = errorMessageService.getMessageForCode(errorCode);
        return new ErrorDto(errorCode, errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleInvalidMethodArgsError(MethodArgumentNotValidException ex) {
        log.error("Exception {} has been caught", ex.getClass().getSimpleName(), ex);

        String errors = ex.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .collect(Collectors.joining("- "));

        return new ErrorDto(ex.getClass().getSimpleName(), errors);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleBusinessError(BusinessException ex) {
        log.error("Exception {} has been caught", ex.getClass().getSimpleName(), ex);
        return createErrorResponse(ex);
    }
}
