package com.fiec.estoqueia.services.impl;

import com.fiec.estoqueia.business.entities.Aluno;
import com.fiec.estoqueia.business.repositories.AlunoRepository;
import com.fiec.estoqueia.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public Optional<Aluno> findAlunoByRmAndSenha(String rm, String senha) {
        return alunoRepository.findByRmAndSenha(rm, senha);
    }

    @Override
    public Optional<Aluno> findAlunoByRm(String rm) {
        return alunoRepository.findByRm(rm);
    }
}