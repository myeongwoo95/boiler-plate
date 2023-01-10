package com.walle.HashMapboard.api;

import com.walle.HashMapboard.api.ApiUser;
import com.walle.HashMapboard.api.exception.UserAlreadyExistsException;
import com.walle.HashMapboard.api.exception.UserNotFoundException;
import com.walle.HashMapboard.api.jwt.JwtTokenProvider;
import com.walle.HashMapboard.api.ApiUserRepository;
import com.walle.HashMapboard.api.request.UserSignInRequest;
import com.walle.HashMapboard.api.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final ApiUserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public void signup(UserSignupRequest userSignupRequest) {
        if (userRepository.existsByUsername(userSignupRequest.getUsername()))
            throw new UserAlreadyExistsException();
        ApiUser apiUser = new ApiUser(userSignupRequest);
        userRepository.save(apiUser);
    }

    public String signIn(UserSignInRequest userSignInRequest) {
        ApiUser user = userRepository.findByUsernameAndPassword(userSignInRequest.getUsername(), userSignInRequest.getPassword()).orElseThrow(UserNotFoundException::new);
        return jwtTokenProvider.generateJwtToken(user.getId(), user.getRole());
    }
}
