package com.ac2.project_ac2.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.ac2.project_ac2.entity.CodeCurso;
import com.ac2.project_ac2.entity.Curso;
import com.ac2.project_ac2.repository.CursoRepository;

@ActiveProfiles("test")
@DataJpaTest
public class CursoRepositoryTest {
	@Autowired
    private CursoRepository cursoRepository;
	
	@Test
    void testSaveAndFindAluno() {
		String name = "Matematica";
		
        Curso aluno = new Curso();
        aluno.setName(name);
        aluno.setCode(new CodeCurso("11111"));

        Curso savedCurso = cursoRepository.save(aluno);
        assertNotNull(savedCurso.getId());


        Optional<Curso> retrievedCurso = cursoRepository.findById(savedCurso.getId());
        assertTrue(retrievedCurso.isPresent());
        assertEquals(name, retrievedCurso.get().getName());
   }
}
