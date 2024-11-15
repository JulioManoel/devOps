package com.ac2.project_ac2.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.ac2.project_ac2.entity.Aluno;
import com.ac2.project_ac2.entity.Email;
import com.ac2.project_ac2.repository.AlunoRepository;

@ActiveProfiles("test")
@DataJpaTest
public class AlunoRepositoryTest {
	@Autowired
    private AlunoRepository alunoRepository;
	
	@Test
    void testSaveAndFindAluno() {
		String name = "testUser";
		
        Aluno aluno = new Aluno();
        aluno.setName(name);
        aluno.setEmail(new Email("test@example.com"));

        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId());


        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        assertTrue(retrievedAluno.isPresent());
        assertEquals(name, retrievedAluno.get().getName());
   }
}
