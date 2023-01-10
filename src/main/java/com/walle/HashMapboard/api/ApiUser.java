package com.walle.HashMapboard.api;

import com.walle.HashMapboard.api.request.UserSignupRequest;
import com.walle.HashMapboard.domain.user.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "users")
@DynamicUpdate
@Data
@NoArgsConstructor
public class ApiUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public ApiUser(UserSignupRequest userSignupRequest) {
        this.username = userSignupRequest.getUsername();
        this.password = userSignupRequest.getPassword();
        this.role = UserRole.ROLE_USER;
    }
}
