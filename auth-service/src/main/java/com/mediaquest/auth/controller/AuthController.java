package com.mediaquest.auth.controller;

import com.mediaquest.auth.payload.dto.CurrentUserResponse;
import com.mediaquest.auth.payload.dto.LoginRequest;
import com.mediaquest.auth.payload.dto.LoginResponse;
import com.mediaquest.auth.payload.dto.UserRequest;
import com.mediaquest.auth.payload.dto.UserResponse;
import com.mediaquest.auth.service.AuthService;
import com.mediaquest.auth.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;
  private final UserService userService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }

  @PreAuthorize("permitAll()")
  @PostMapping("/register")
  public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest){
    return ResponseEntity.ok(userService.saveUser(userRequest));
  }

  @GetMapping("/me")
  public ResponseEntity<CurrentUserResponse> me(Authentication authentication) {
    List<String> roles = authentication.getAuthorities()
        .stream()
        .map(authority -> authority.getAuthority())
        .toList();

    return ResponseEntity.ok(new CurrentUserResponse(authentication.getName(), roles));
  }
}
