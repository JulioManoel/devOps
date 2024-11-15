package com.ac2.project_ac2.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ac2.project_ac2.entity.CodeCurso;
import com.ac2.project_ac2.entity.Curso;

public class CursoTest {
	@Test
    void testSetAndGetCode() {
        Curso curso = new Curso();
        CodeCurso codeCurso = new CodeCurso("usuario.exemplo+teste@gmail.com");
        curso.setCode(codeCurso);
        
        assertEquals(codeCurso, curso.getCode());
    }
}
