package com.fiec.estoqueia.services.impl;

import com.fiec.estoqueia.business.entities.Aluno;
import com.fiec.estoqueia.business.repositories.AlunoRepository;
import com.fiec.estoqueia.services.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AlunoRepository alunoRepository;

    private String jwtSecret = "062a569fc4f8e8edb03a5323af481aab46eb0c887ce11427be1c122990493ece62fdd0e26855b057f5100719b55aa44d119e9dcf01e79baa8a1a10d4f1121767";
    private long jwtExpirationMs = 86400000; // 24 hours

    public String generateJwtToken(String userId, String rm) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("rm", rm)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Optional<Aluno> authenticateUser(String rm, String senha) {
        return alunoRepository.findByRmAndSenha(rm, senha);
    }
}