package com.mediaquest.auth.payload.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CurrentUserResponse {
  private String username;
  private List<String> roles;
}
