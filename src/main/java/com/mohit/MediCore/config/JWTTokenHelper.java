package com.mohit.MediCore.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.JwtParser;
//import io.jsonwebtoken.security.Keys;
//import io.jsonwebtoken.io.Decoders;
import javax.crypto.SecretKey;

//import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Component
public class JWTTokenHelper {

    private static final String AUTH_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    @Value("${jwt.auth.app}")
    private String appName;

    @Value("${jwt.auth.secret_key}")
    private String secretKey;

    @Value("${jwt.auth.expires_in}")
    private int expiresIn; // in seconds

    // Generate JWT token for the user
    public String generateToken(String userName) {
        return Jwts.builder()
                .issuer(appName)
                .subject(userName)
                .issuedAt(new Date())
                .expiration(generateExpirationDate())
                .signWith(getSigningKey())
                .compact();
    }

    // Create a signing key from the base64-encoded secret
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generate token expiration date
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiresIn * 1000L);
    }

    // Extract JWT token from request headers
    public String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader(AUTH_HEADER);
        if (authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
            return authHeader.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    // Validate token with user details
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username != null &&
                username.equals(userDetails.getUsername()) &&
                !isTokenExpired(token);
    }

    // Check if token is expired
    private boolean isTokenExpired(String token) {
        Date expiration = getExpirationDate(token);
        return expiration != null && expiration.before(new Date());
    }

    // Get expiration date from token
    private Date getExpirationDate(String token) {
        return getAllClaimsFromToken(token)
                .map(Claims::getExpiration)
                .orElse(null);
    }

    // Extract username from token
    public String getUserNameFromToken(String token) {
        return getAllClaimsFromToken(token)
                .map(Claims::getSubject)
                .orElse(null);
    }

    // Parse all claims safely using Optional
    private Optional<Claims> getAllClaimsFromToken(String token) {
        try {
            SecretKey key = getSigningKey();
            Claims claims = Jwts.parser()                 // Build parser
                    .verifyWith(key)                      // Signature verification key
                    .build()                              // Build the parser
                    .parseSignedClaims(token)             // Parse the JWT
                    .getPayload();                        // Get Claims (payload)

            return Optional.of(claims);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
