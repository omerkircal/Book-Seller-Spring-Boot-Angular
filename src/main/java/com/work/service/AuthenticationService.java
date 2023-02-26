package com.work.service;

import com.work.model.User;
import com.work.security.UserPrincipal;
import com.work.security.jwt.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public AuthenticationService(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    public User signInAndReturnJWT(User signInRequest){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
        );
        UserPrincipal userPrincipal= (UserPrincipal) authentication.getPrincipal();
        String jwT= jwtProvider.generateToken(userPrincipal);

        User signInUser=userPrincipal.getUser();
        signInUser.setToken(jwT);

        return signInUser;
    }
}
