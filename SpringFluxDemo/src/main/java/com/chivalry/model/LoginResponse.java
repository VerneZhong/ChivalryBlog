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
    private String status;

    public LoginResponse(String token) {
        this.token = token;
        this.status = "success";
    }

    public LoginResponse(String token, String status) {
        this.token = token;
        this.status = status;
    }
}
