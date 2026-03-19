package com.mediaquest.auth.config;

import com.mediaquest.auth.entity.User;
import com.mediaquest.auth.entity.UserRole;
import com.mediaquest.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SeedConfig {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Bean
  public CommandLineRunner seedAdmin() {
    return args -> {
      if (userRepository.findByUsername("admin").isEmpty()) {
        User admin = User.builder()
            .username("admin")
                .email("admin@mediaquest.com")
            .passwordHash(passwordEncoder.encode("Admin123!"))
            .role(UserRole.ADMIN)
            .build();

        userRepository.save(admin);
      }
    };
  }
}
