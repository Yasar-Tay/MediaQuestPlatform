package com.smartedu.auth.payload.dto;

import com.smartedu.auth.entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

  @NotBlank
  @Size(min = 2, max = 40)
  private String username;

  @Email
  private String email;

  @NotBlank
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).{8,}$",
      message = "Password must contain upper, lower, digit and special char, min 8")
  private String password;

  @NotBlank
  private UserRole userRole;

}
