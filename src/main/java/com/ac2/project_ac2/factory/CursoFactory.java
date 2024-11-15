package com.ac2.project_ac2.factory;

import java.util.ArrayList;

import com.ac2.project_ac2.entity.Aluno;
import com.ac2.project_ac2.entity.CodeCurso;
import com.ac2.project_ac2.entity.Curso;

public class CursoFactory {
	public static Curso build(Long id, String nome, String codigo) {
        Curso curso = new Curso();
        curso.setId(id);
        curso.setName(nome);
        curso.setCode(new CodeCurso(codigo));
        curso.setAlunos(new ArrayList<Aluno>());        
        return curso;
    }
}
