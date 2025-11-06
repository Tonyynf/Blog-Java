package com.descomplica.BlogProject.models;

import com.descomplica.BlogProject.enums.RoleEnum;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "User")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserId;
    private String name;
    private String email;
    private String password;
    private RoleEnum role;
    private String username;

    public User(final Long userId, final String name, final String email, final String password, final RoleEnum role, final String username) {
        UserId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    public User() {

    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == RoleEnum.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
            return List.of(
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }


        @Override
        public boolean isAccountNonExpired () {
            return true;
        }

}