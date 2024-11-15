package com.ac2.project_ac2.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ac2.project_ac2.entity.Aluno;
import com.ac2.project_ac2.entity.Curso;
import com.ac2.project_ac2.factory.AlunoFactory;
import com.ac2.project_ac2.factory.CursoFactory;
import com.ac2.project_ac2.repository.CursoRepository;
import com.ac2.project_ac2.service.BaseService;
import com.ac2.project_ac2.service.CursoService;

public class CursoServiceTest {
	@Mock
	private CursoRepository cursoRepository;
	
	@InjectMocks
	private CursoService cursoService;
	
	@InjectMocks
	private BaseService<Curso, Long> baseService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetAllAlunos() {
		Aluno aluno1 = AlunoFactory.build(1L, "Julio", "julio@gmail.com");
		Aluno aluno2 = AlunoFactory.build(2L, "Rafael", "rafael@gmail.com");	    
	    List<Aluno> alunosCurso1 = Arrays.asList(aluno1, aluno2);
	    
	    Aluno aluno3 = AlunoFactory.build(3L, "Isabela", "isabela@gmail.com");
	    Aluno aluno4 = AlunoFactory.build(4L, "Pedro", "pedro@gmail.com");	    
	    List<Aluno> alunosCurso2 = Arrays.asList(aluno3, aluno4);
	    
	    Curso curso1 = CursoFactory.build(1L, "Matemática", "MAT101");
	    Curso curso2 = CursoFactory.build(2L, "História", "HIS202");
	    
	    curso1.setAlunos(alunosCurso1);
	    curso2.setAlunos(alunosCurso2);
	    
	    when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso1, curso2));
	    
	    List<Curso> cursos = baseService.all();
	    assertEquals(2, cursos.size());
	    
	    assertEquals("Matemática", cursos.get(0).getName());
	    assertEquals("MAT101", cursos.get(0).getCode().getCode());
	    assertEquals(2, cursos.get(0).getAlunos().size());
	    assertEquals("Julio", cursos.get(0).getAlunos().get(0).getName());
	    assertEquals("rafael@gmail.com", cursos.get(0).getAlunos().get(1).getEmail().getAddress());

	    assertEquals("História", cursos.get(1).getName());
	    assertEquals("HIS202", cursos.get(1).getCode().getCode());
	    assertEquals(2, cursos.get(1).getAlunos().size());
	    assertEquals("Isabela", cursos.get(1).getAlunos().get(0).getName());
	    assertEquals("pedro@gmail.com", cursos.get(1).getAlunos().get(1).getEmail().getAddress());
	}
}
