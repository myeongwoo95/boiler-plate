package com.walle.HashMapboard.api;


import com.walle.HashMapboard.api.request.UserSignInRequest;
import com.walle.HashMapboard.api.request.UserSignupRequest;
import com.walle.HashMapboard.api.response.UserSignInResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @ApiOperation(value = "회원가입")
    @PostMapping("/v1/api/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody UserSignupRequest userSignupRequest) {
        authService.signup(userSignupRequest);
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/v1/api/auth/signin")
    @ResponseStatus(HttpStatus.OK)
    public UserSignInResponse signIn(
            @RequestBody UserSignInRequest userSignInRequest
    ) {
        String accessToken = authService.signIn(userSignInRequest);
        return new UserSignInResponse(accessToken);
    }
}
