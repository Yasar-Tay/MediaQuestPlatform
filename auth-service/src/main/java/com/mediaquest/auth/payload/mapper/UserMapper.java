package com.mediaquest.auth.payload.mapper;

import com.mediaquest.auth.entity.User;
import com.mediaquest.auth.payload.dto.UserRequest;
import com.mediaquest.auth.payload.dto.UserResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserMapper {

  public UserResponse toUserResponse(User user){
    return UserResponse.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .role(user.getRole())
        .build();
  }

  public User toUser(UserRequest userRequest){
      return User.builder()
          .username(userRequest.getUsername())
          .email(userRequest.getEmail())
          .role(userRequest.getUserRole())
          //password will be added in service layer
          .build();
  }

}
