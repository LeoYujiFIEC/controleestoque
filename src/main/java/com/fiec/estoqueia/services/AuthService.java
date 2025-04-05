package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.entities.Aluno;

import java.util.Optional;

public interface AuthService {
    String generateJwtToken(String userId, String rm);
    Optional<Aluno> authenticateUser(String rm, String senha);
}