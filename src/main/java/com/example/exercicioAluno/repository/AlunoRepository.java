package com.example.exercicioAluno.repository;

import com.example.exercicioAluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
