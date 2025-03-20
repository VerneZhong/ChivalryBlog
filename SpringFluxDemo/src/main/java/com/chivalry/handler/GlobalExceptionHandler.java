package com.chivalry.handler;

import com.chivalry.response.LoginErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

/**
 * @author verne.zhong
 * @date 2025/03/19
 * @description TODO
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 处理认证失败（例如用户名或密码错误）
    @ExceptionHandler(BadCredentialsException.class)
    public Mono<ResponseEntity<LoginErrorResponse>> handleBadCredentialsException(BadCredentialsException ex) {
        LoginErrorResponse errorResponse = new LoginErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                "用户名密码错误.",
                ex.getMessage()
        );
        return Mono.just(new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED));
    }

    // 处理账户锁定错误
    @ExceptionHandler(LockedException.class)
    public Mono<ResponseEntity<LoginErrorResponse>> handleLockedException(LockedException ex) {
        LoginErrorResponse errorResponse = new LoginErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                "账户被锁定",
                ex.getMessage()
        );
        return Mono.just(new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN));
    }

    // 处理校验错误（例如请求参数不符合要求）
    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseEntity<LoginErrorResponse>> handleValidationException(ConstraintViolationException ex) {
        StringBuilder errorMessage = new StringBuilder();
        ex.getConstraintViolations().forEach(violation -> errorMessage.append("Field: ").append(violation.getPropertyPath())
                .append(" - ").append(violation.getMessage()).append("; "));

        LoginErrorResponse errorResponse = new LoginErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "参数校验失败",
                errorMessage.toString()
        );
        return Mono.just(new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST));
    }

    // 处理其他未知错误
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<LoginErrorResponse>> handleGeneralException(Exception ex) {
        LoginErrorResponse errorResponse = new LoginErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "系统错误.",
                ex.getMessage()
        );
        ex.printStackTrace();
        return Mono.just(new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
