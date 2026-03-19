package com.mediaquest.auth.service;

import com.mediaquest.auth.payload.dto.LoginRequest;
import com.mediaquest.auth.payload.dto.LoginResponse;
import com.mediaquest.auth.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  public LoginResponse login(LoginRequest request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );

    String token = jwtService.generateToken(authentication);

    return new LoginResponse(authentication.getName(), token, "Bearer");
  }
}
