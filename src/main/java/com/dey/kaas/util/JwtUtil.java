package com.dey.kaas.util;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;


@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    String secret;

    public Key generateKey(String secret){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username) throws WeakKeyException, InvalidKeyException {

        Claims claims = Jwts.claims();;
        claims.put("username", username);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 100*60*60*60))
                .setIssuer("Sanat Dey")
                .signWith(generateKey(secret))
                .compact();
    }

    public Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(generateKey(secret))
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    public Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(generateKey(secret))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean isTokenExpired(String token) {

        Date exp = extractClaims(token).getExpiration();
        Date now = new Date(System.currentTimeMillis());
        return exp.before(now);
    }

    public String validateToken(String token) {
        String tusername = extractClaims(token).getSubject();
        if(tusername != null) {
            if(!isTokenExpired(token)) {
                return tusername;
            }
        }
        return null;
    }

}