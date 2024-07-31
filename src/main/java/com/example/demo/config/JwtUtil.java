package com.example.demo.config;


import com.example.demo.Role.UserRole;
import com.example.demo.dto.DevDto;
import com.example.demo.entity.Developper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

@Component
public class JwtUtil {

    private static final String SECRET = "84d38876b12c843f4670837210169abafa43de2eebc733957af68ca1d3544e8b";

    public String generateToken(String username, Optional<Developper> user1) {
        Map<String, Object> claims = new HashMap<>();
        Developper user = user1.orElse(new Developper());
        return createToken(claims, username,user.getId(),user.getImage(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
    }

    public String createToken(Map<String, Object> claims, String username, int id, String image, String firstName, String lastName, String email, UserRole role) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .claim("firstName", firstName)  // Ajouter le prénom
                .claim("lastName", lastName)
                .claim("id", id)  // Ajouter le prénom
                .claim("image", image)   // Ajouter le nom de famille
                .claim("email", email)          // Ajouter l'e-mail
                .claim("role", role)            // Ajouter le rôle
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}