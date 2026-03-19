package com.mediaquest.auth.security;

import com.mediaquest.auth.entity.User;
import com.mediaquest.auth.exception.ResourceNotFoundException;
import com.mediaquest.auth.payload.message.ErrorMessage;
import com.mediaquest.auth.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(String.format(
        ErrorMessage.USER_WITH_USERNAME_NOT_FOUND, username)));

    return new org.springframework.security.core.userdetails.User(
        user.getUsername(),
        user.getPasswordHash(),
        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
    );

  }
}
