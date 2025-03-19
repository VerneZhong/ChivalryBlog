package com.chivalry.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author verne.zhong
 * @date 2025/03/18
 * @description TODO
 */
@Data
public class LoginRequest {
    @NotBlank(message = "Password cannot be empty")  // 非空且去除空格
    private String username;
    @NotBlank(message = "Password cannot be empty")  // 非空且去除空格
    private String password;
}
