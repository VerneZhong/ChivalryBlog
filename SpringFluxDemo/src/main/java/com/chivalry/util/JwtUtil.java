package com.chivalry.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author verne.zhong
 * @date 2025/03/20
 * @description TODO
 */
public class JwtUtil {
    // ✅ 32字节以上的密钥
    private static final String SECRET = "MySuperSecretKey12345678901234567890";
    // ✅ 生成 SecretKey
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public static String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                // 1小时有效
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SECRET_KEY)
                .compact();
    }

}
