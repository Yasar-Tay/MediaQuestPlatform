package com.mediaquest.auth.payload.dto;

import com.mediaquest.auth.entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

  @NotBlank
  @Size(min = 2, max = 40)
  private String username;

  @NotBlank
  @Email(message = "Email format is invalid")
  private String email;

  @NotBlank
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).{8,}$",
      message = "Password must contain upper, lower, digit and special char, min 8")
  private String password;

  @NotNull
  private UserRole userRole;

}
