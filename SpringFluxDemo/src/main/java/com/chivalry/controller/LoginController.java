package com.chivalry.controller;

import com.chivalry.model.LoginRequest;
import com.chivalry.model.LoginResponse;
import com.chivalry.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 登陆入口
 * @author verne.zhong
 * @date 2025/03/18
 * @description
 */
@RestController
@RequestMapping("/api/")
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<LoginResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest)
                // 登录成功，返回 token
                .map(token -> ResponseEntity.ok(new LoginResponse(token)))
                // 登录失败，返回 bad request
                .defaultIfEmpty(ResponseEntity.badRequest().body(new LoginResponse("Invalid credentials")))
                .onErrorResume(e -> {
                    // 根据不同的错误类型返回不同的响应
                    if (e instanceof BadCredentialsException) {
                        return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                .body(new LoginResponse("Invalid username or password")));
                    } else if (e instanceof LockedException) {
                        return Mono.just(ResponseEntity.status(HttpStatus.FORBIDDEN)
                                .body(new LoginResponse("Your account is locked")));
                    } else {
                        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(new LoginResponse("An unexpected error occurred")));
                    }
                });
    }
}
