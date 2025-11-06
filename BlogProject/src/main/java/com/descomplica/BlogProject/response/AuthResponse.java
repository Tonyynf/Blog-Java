package com.descomplica.BlogProject.response;

public class AuthResponse {
    final String token;

    public AuthResponse(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}
