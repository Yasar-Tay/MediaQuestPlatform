package com.mediaquest.auth.repository;

import com.mediaquest.auth.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);

  boolean existsByEmailAndIdNot(String email, Long id);

  boolean existsByUsernameAndIdNot(String username, Long id);

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

}
