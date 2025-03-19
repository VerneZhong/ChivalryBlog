package com.chivalry.service;

import com.chivalry.model.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author verne.zhong
 * @date 2025/03/18
 * @description TODO
 */
@Service
public class AuthService {

    private static final String SECRET_KEY = "user_secret_key";

    public Mono<String> login(LoginRequest loginRequest) {
        // 简单的用户名和密码验证
        if ("admin".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())) {
            // 生成 JWT token
            String token = Jwts.builder().subject(loginRequest.getUsername())
                    // 1小时有效期
                    .expiration(new Date(System.currentTimeMillis() + 3600000))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
            return Mono.just(token);
        } else {
            return Mono.empty();
        }
    }
}
