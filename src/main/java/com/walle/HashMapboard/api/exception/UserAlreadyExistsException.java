package com.walle.HashMapboard.api.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("이미 존재하는 아이디입니다.");
    }
}