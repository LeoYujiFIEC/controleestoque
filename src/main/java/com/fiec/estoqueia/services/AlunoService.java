package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.entities.Aluno;

import java.util.Optional;

public interface AlunoService {
    Optional<Aluno> findAlunoByRmAndSenha(String rm, String senha);
    Optional<Aluno> findAlunoByRm(String rm);
}