package com.pig.base64;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	 private String SECRET_KEY = "your-256-bit-secret";
    public String generateToken(String  name) {
        Map<String, Object> claims = new HashMap<>();
        //這邊放payload內容
        claims.put("sub", "1234567890");
        claims.put("name", "John Doe");
        claims.put("iat", 1516239022);
        return createToken(claims, name);
    }

    private String createToken(Map<String, Object> claims, String subject) {
    	Header header = Jwts.header();
        header.setType("JWT");
        
//        return Jwts.builder().setHeader((Map<String, Object>) 
//                header).setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        
        return Jwts.builder().setHeader((Map<String, Object>) 
                header).setClaims(claims).setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, new String(Base64.getEncoder().encode(SECRET_KEY.getBytes()))).compact();
    }
}
