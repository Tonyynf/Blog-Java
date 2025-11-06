package com.descomplica.BlogProject.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.descomplica.BlogProject.models.User;
import com.descomplica.BlogProject.repositories.UserRepository;
import com.descomplica.BlogProject.request.AuthRequest;
import com.descomplica.BlogProject.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.time.Instant;
import java.time.ZoneOffset;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        return userRepository.findByUsername(login);
    }

    @Override
    public String getToken(AuthRequest auth){
        User user = userRepository.findByUsername(auth.getUsername());
        return generateToken(user);
    }

    @Override
    public String valiidateJwtToken(String token) {
        return "";
    }

    private String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC512("my-secret");

            return JWT.create()
                    .withIssuer("BlogProject")
                    .withSubject(user.getUsername())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Fail to generate token" +exception.getMessage());
        }
    }

    public String validateJwtToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512("my-secret");

            return JWT.require(algorithm)
                    .withIssuer("BlogProject")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception) {
            return "";
        }
    }

    private Instant getExpirationDate(){
        return LocalDateTime.now()
                .plusHours(8)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
