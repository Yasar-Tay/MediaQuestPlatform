package com.mediaquest.auth.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
  private String username;
  private String token;
  private String tokenType;
}
