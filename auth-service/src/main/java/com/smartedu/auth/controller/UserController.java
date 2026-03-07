package com.smartedu.auth.controller;

import com.smartedu.auth.payload.dto.UserRequest;
import com.smartedu.auth.payload.dto.UserResponse;
import com.smartedu.auth.service.UserService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping()
  public ResponseEntity<Page<UserResponse>> getUsers(
      @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable
  ) {
    return ResponseEntity.ok(userService.getAllUsers(pageable));
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @PreAuthorize("permitAll()")
  @PostMapping("/register")
  public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest){
    return ResponseEntity.ok(userService.saveUser(userRequest));
  }

  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id){
    return ResponseEntity.ok(userService.removeUser(id));
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/update/{id}")
  public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest){
    return ResponseEntity.ok(userService.updateUser(id, userRequest));
  }


}
