package com.walle.HashMapboard.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
   public User findByUsername(String username);

   // API용
   Optional<User> findByUsernameAndPassword(String username, String password);
   boolean existsByUsername(String username);
}
