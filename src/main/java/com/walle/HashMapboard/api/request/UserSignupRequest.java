package com.walle.HashMapboard.api.request;

import lombok.Data;

@Data
public class UserSignupRequest {
    private String username;
    private String password;
}
