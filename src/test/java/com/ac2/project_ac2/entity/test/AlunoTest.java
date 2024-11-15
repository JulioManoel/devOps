package com.ac2.project_ac2.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ac2.project_ac2.entity.Aluno;
import com.ac2.project_ac2.entity.Email;

public class AlunoTest {
	@Test
    void testSetAndGetValidEmail() {
        Aluno aluno = new Aluno();
        Email email = new Email("usuario.exemplo+teste@gmail.com");
        aluno.setEmail(email);
        
        assertEquals(email, aluno.getEmail());
    }

    @Test
    void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Email("invalid-email");
        });
    }
}
