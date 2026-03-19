package com.mediaquest.auth.service;

import com.mediaquest.auth.entity.User;
import com.mediaquest.auth.exception.ConflictException;
import com.mediaquest.auth.exception.ResourceNotFoundException;
import com.mediaquest.auth.payload.dto.UserRequest;
import com.mediaquest.auth.payload.dto.UserResponse;
import com.mediaquest.auth.payload.mapper.UserMapper;
import com.mediaquest.auth.payload.message.ErrorMessage;
import com.mediaquest.auth.repository.UserRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;

  private User findUserById(Long id){
    return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.format(ErrorMessage.USER_WITH_ID_NOT_FOUND, id)));
  }

  private void validateUserExist(UserRequest userRequest) {
    if (userRepository.existsByEmail(userRequest.getEmail()))
      throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXISTS, userRequest.getEmail()));

    if (userRepository.existsByUsername(userRequest.getUsername()))
      throw new ConflictException(String.format(ErrorMessage.USERNAME_ALREADY_EXISTS, userRequest.getUsername()));
  }


  public Page<UserResponse> getAllUsers(Pageable pageable) {
    Page<User> users = userRepository.findAll(pageable);

    if (users.getTotalElements() == 0) { throw  new ResourceNotFoundException(ErrorMessage.NO_USER_FOUND); }

    return users.map(userMapper::toUserResponse);
  }


  public UserResponse getUserById(Long id) {
    User user = findUserById(id);
    return userMapper.toUserResponse(user);
  }


  @Transactional
  public UserResponse saveUser(UserRequest userRequest) {

    validateUserExist(userRequest);

    User user = userMapper.toUser(userRequest);
    user.setPasswordHash(passwordEncoder.encode(userRequest.getPassword()));
    User savedUser = userRepository.save(user);

    return userMapper.toUserResponse(savedUser);
  }

  @Transactional
  public Map<String, String> removeUser(Long id) {
    User user = findUserById(id);
    userRepository.delete(user);
    return Map.of("message", "success");
  }

  @Transactional
  public UserResponse updateUser(Long id, UserRequest userRequest) {
    if (userRepository.existsByEmailAndIdNot(userRequest.getEmail(), id)) {
      throw new ConflictException(
          String.format(ErrorMessage.EMAIL_ALREADY_EXISTS, userRequest.getEmail())
      );
    }

    if (userRepository.existsByUsernameAndIdNot(userRequest.getUsername(), id)) {
      throw new ConflictException(
          String.format(ErrorMessage.USERNAME_ALREADY_EXISTS, userRequest.getUsername())
      );
    }

    User user = findUserById(id);
    user.setId(user.getId());
    user.setEmail(userRequest.getEmail());
    user.setUsername(userRequest.getUsername());
    if (userRequest.getPassword() != null) {
      user.setPasswordHash(passwordEncoder.encode(userRequest.getPassword()));
    }
    user.setRole(userRequest.getUserRole());
    User savedUser = userRepository.save(user);
    return userMapper.toUserResponse(savedUser);
  }
}
