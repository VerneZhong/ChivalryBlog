package com.chivalry.controller;

import com.chivalry.model.LoginRequest;
import com.chivalry.model.LoginResponse;
import com.chivalry.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author verne.zhong
 * @date 2025/03/18
 * @description TODO
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private AuthService authService;

    @PostMapping
    public Mono<ResponseEntity<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest)
                .map(token -> ResponseEntity.ok(new LoginResponse(token)))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
