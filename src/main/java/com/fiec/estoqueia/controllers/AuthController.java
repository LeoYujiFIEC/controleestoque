package com.fiec.estoqueia.controllers;

import com.fiec.estoqueia.business.dtos.AlunoLoginDto;
import com.fiec.estoqueia.business.entities.Aluno;
import com.fiec.estoqueia.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AlunoLoginDto alunoLoginDto) {
        log.info("AuthController - authenticateUser - Aluno entrando no sistema {}", alunoLoginDto);
        Optional<Aluno> aluno = authService.authenticateUser(alunoLoginDto.getRm(), alunoLoginDto.getSenha());

        if (aluno.isPresent()) {
            String token = authService.generateJwtToken(aluno.get().getId().toString(), aluno.get().getRm());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @DeleteMapping("/logout")
    public void deleteUser() {

    }
}