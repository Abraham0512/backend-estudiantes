package com.backend.estudiantes.service;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JWTService {

    @Value("${app.jwt.secret}")
    private String secretKey;

    @Value("${app.jwt.expirationMs}")
    private Long jwtExpirationMs;

    /*interfaz para transformar el secret en binario*/
    private Key getSignInKey() {

        byte []  keyByte = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyByte);
    }

}
