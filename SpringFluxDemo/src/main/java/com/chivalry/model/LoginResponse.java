package com.chivalry.model;

import lombok.Data;

/**
 * @author verne.zhong
 * @date 2025/03/18
 * @description TODO
 */
@Data
public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
