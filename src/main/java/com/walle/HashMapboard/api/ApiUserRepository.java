package com.walle.HashMapboard.api;

import com.walle.HashMapboard.api.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ApiUserRepository extends JpaRepository<ApiUser, Integer> {
    Optional<ApiUser> findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);
}
