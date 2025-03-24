package com.chivalry.service;

import com.chivalry.dao.UsersRepository;
import com.chivalry.entity.UserEntity;
import com.chivalry.model.LoginRequest;
import com.chivalry.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * AuthService 验证服务
 * @author verne.zhong
 * @date 2025/03/18
 * @description
 */
@Service
public class AuthService {

    private final UsersRepository usersRepository;

    public AuthService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Mono<String> login(LoginRequest loginRequest) {
        UserEntity user = usersRepository.findByUsername(loginRequest.getUsername());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // 生成 JWT token
            String token = JwtUtil.generateToken(loginRequest.getUsername());
            return Mono.just(token);
        } else {
            return Mono.error(new BadCredentialsException("Invalid username or password"));
        }
    }
}
