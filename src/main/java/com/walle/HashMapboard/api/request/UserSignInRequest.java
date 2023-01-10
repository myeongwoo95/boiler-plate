package com.walle.HashMapboard.api.request;

import lombok.Data;

@Data
public class UserSignInRequest {
    private String username;
    private String password;
}