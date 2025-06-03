package com.example.eventhello.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService { private static final String SECRET_KEY = "53e620f204aae41dc2a6f28405ca0287203c79322d4b6225291de96c88e8b13d";
    public String extractUsername(String jwttoken) {

        return extractClaim(jwttoken, Claims::getSubject);
    }

    public <T> T extractClaim(String jwttoken, Function<Claims, T> claimsResolver) {
        final Claims claims =extractClaims(jwttoken);
        return claimsResolver.apply(claims);
    }
    private Claims extractClaims(String jwttoken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build().parseClaimsJws(jwttoken)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isTokenValid(String jwttoken,UserDetails userDetails) {
        final String username = extractUsername(jwttoken);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(jwttoken);
    }

    private boolean isTokenExpired(String jwttoken) {
        return extractExpiration(jwttoken).before(new Date());
    }

    private Date extractExpiration(String jwttoken) {
        return extractClaim(jwttoken, Claims::getExpiration);
    }

    public  String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000 *60*60*24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

    }
}
