package com.ac2.project_ac2.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ac2.project_ac2.entity.Aluno;
import com.ac2.project_ac2.entity.Curso;
import com.ac2.project_ac2.factory.AlunoFactory;
import com.ac2.project_ac2.factory.CursoFactory;
import com.ac2.project_ac2.repository.AlunoRepository;
import com.ac2.project_ac2.repository.CursoRepository;
import com.ac2.project_ac2.service.AlunoService;
import com.ac2.project_ac2.service.BaseService;

import jakarta.persistence.EntityNotFoundException;

public class AlunoServiceTest {
	@Mock
	private AlunoRepository alunoRepository;
	
	@Mock
	private CursoRepository cursoRepository;
	
	@InjectMocks
	private BaseService<Aluno, Long> baseService;
	
	@InjectMocks
	private AlunoService alunoService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetAllAlunos() {
		Curso curso1 = CursoFactory.build(1L, "Matemática", "MAT101");
	    Curso curso2 = CursoFactory.build(2L, "História", "HIS202");		
	    List<Curso> cursosAluno1 = Arrays.asList(curso1, curso2);
	    
	    Curso curso3 = CursoFactory.build(3L, "Física", "FIS303");
	    Curso curso4 = CursoFactory.build(4L, "Química", "QUI404");
	    List<Curso> cursosAluno2 = Arrays.asList(curso3, curso4);
		
	    Aluno aluno = AlunoFactory.build(1L, "Julio", "julio@gmail.com");
	    aluno.setCursos(cursosAluno1);
		
	    Aluno aluno2 = AlunoFactory.build(2L, "Rafael", "rafael@gmail.com");
	    aluno2.setCursos(cursosAluno2);
		
		when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno, aluno2));
		
		List<Aluno> alunos = baseService.all();
		assertEquals(2, alunos.size());
		
		assertEquals("Julio", alunos.get(0).getName());
	    assertEquals("julio@gmail.com", alunos.get(0).getEmail().getAddress());
	    assertEquals(2, alunos.get(0).getCursos().size());
	    assertEquals("Matemática", alunos.get(0).getCursos().get(0).getName());
	    assertEquals("MAT101", alunos.get(0).getCursos().get(0).getCode().getCode());
	    assertEquals("História", alunos.get(0).getCursos().get(1).getName());
	    assertEquals("HIS202", alunos.get(0).getCursos().get(1).getCode().getCode());
	    
	    assertEquals("Rafael", alunos.get(1).getName());
	    assertEquals("rafael@gmail.com", alunos.get(1).getEmail().getAddress());
	    assertEquals(2, alunos.get(1).getCursos().size());
	    assertEquals("Física", alunos.get(1).getCursos().get(0).getName());
	    assertEquals("FIS303", alunos.get(1).getCursos().get(0).getCode().getCode());
	    assertEquals("Química", alunos.get(1).getCursos().get(1).getName());
	    assertEquals("QUI404", alunos.get(1).getCursos().get(1).getCode().getCode());
	}
	
	@Test
	void testInscreverAlunoNoCursoComSucesso() {
	    Aluno aluno = AlunoFactory.build(1L, "Julio", "example@gmail.com");
	    Curso curso = CursoFactory.build(1L, "Matemática Avançada", "MAT101");

	    when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));
	    when(cursoRepository.findById(1L)).thenReturn(Optional.of(curso));

	    alunoService.inscrever(1L, 1L);

	    assertEquals(1, aluno.getCursos().size());
	    assertEquals(curso, aluno.getCursos().get(0));
	}
	
	@Test
    void testInscreverAlunoJaInscritoNoCurso() {
		Aluno aluno = AlunoFactory.build(1L, "Julio", "example@gmail.com");
	    Curso curso = CursoFactory.build(1L, "Matemática Avançada", "MAT101");
        aluno.getCursos().add(curso);

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));
        when(cursoRepository.findById(1L)).thenReturn(Optional.of(curso));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            alunoService.inscrever(1L, 1L);
        });

        assertEquals("Aluno já inscrito neste curso", exception.getMessage());
    }
	
	@Test
    void testInscreverAlunoNaoEncontrado() {
        when(alunoRepository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            alunoService.inscrever(1L, 1L);
        });

        assertEquals("Aluno não encontrado", exception.getMessage());
    }
	
	@Test
    void testInscreverCursoNaoEncontrado() {
		Aluno aluno = AlunoFactory.build(1L, "Julio", "example@gmail.com");
		
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));
        when(cursoRepository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            alunoService.inscrever(1L, 1L);
        });

        assertEquals("Curso não encontrado", exception.getMessage());
    }
}
