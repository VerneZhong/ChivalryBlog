package com.chivalry.response;

import lombok.Data;

/**
 * @author verne.zhong
 * @date 2025/03/19
 * @description TODO
 */
@Data
public class LoginErrorResponse {
    private int status;
    private String message;
    private String details;

    public LoginErrorResponse(int status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
