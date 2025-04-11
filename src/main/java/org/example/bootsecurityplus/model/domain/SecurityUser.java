package org.example.bootsecurityplus.model.domain;

import java.time.LocalDateTime;

public record SecurityUser (
        Long userId,
        String username,
        String password,
        String role,
        LocalDateTime createAt
){
    public static SecurityUser toDB(String username, String password, String role) {
        return new SecurityUser(null, username, password, role, null);
    }
}
