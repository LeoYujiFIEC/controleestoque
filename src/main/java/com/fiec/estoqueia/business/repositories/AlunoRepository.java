package com.fiec.estoqueia.business.repositories;

import com.fiec.estoqueia.business.entities.Aluno;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, ObjectId> {
    Optional<Aluno> findByRmAndSenha(String rm, String senha);
    Optional<Aluno> findByRm(String rm);
}