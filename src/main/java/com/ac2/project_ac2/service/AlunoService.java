package com.ac2.project_ac2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac2.project_ac2.entity.Aluno;
import com.ac2.project_ac2.entity.Curso;
import com.ac2.project_ac2.repository.AlunoRepository;
import com.ac2.project_ac2.repository.CursoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService extends BaseService<Aluno, Long> {
	@Autowired
    private AlunoRepository alunoRepository;
	
	@Autowired
    private CursoRepository cursoRepository;
	
	public void inscrever(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
        
        boolean isCursoPresentInAluno = aluno.getCursos().stream().anyMatch(c -> c.getId() == 1);
        if (isCursoPresentInAluno) {
            throw new RuntimeException("Aluno já inscrito neste curso");
        }

        List<Curso> cursos = aluno.getCursos();
        cursos.add(curso);
        aluno.setCursos(cursos);
        alunoRepository.save(aluno);
    }
}
