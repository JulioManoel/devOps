package com.ac2.project_ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac2.project_ac2.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {}
