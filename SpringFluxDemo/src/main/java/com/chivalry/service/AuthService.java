package com.chivalry.service;

import com.chivalry.model.LoginRequest;
import com.chivalry.util.JwtUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author verne.zhong
 * @date 2025/03/18
 * @description TODO
 */
@Service
public class AuthService {

    public Mono<String> login(LoginRequest loginRequest) {
        // 简单的用户名和密码验证
        if ("admin".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())) {
            // 生成 JWT token
            String token = JwtUtil.generateToken(loginRequest.getUsername());
            return Mono.just(token);
        } else {
            return Mono.empty();
        }
    }
}
