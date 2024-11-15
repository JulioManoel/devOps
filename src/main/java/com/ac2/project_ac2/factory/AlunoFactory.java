package com.ac2.project_ac2.factory;

import java.util.ArrayList;

import com.ac2.project_ac2.entity.Aluno;
import com.ac2.project_ac2.entity.Curso;
import com.ac2.project_ac2.entity.Email;

public class AlunoFactory {
	public static Aluno build(Long id, String nome, String email) {
        Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setName(nome);
        aluno.setEmail(new Email(email));
        aluno.setCursos(new ArrayList<Curso>());
        return aluno;
    }
}
