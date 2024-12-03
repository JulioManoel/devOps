package com.ac2.project_ac2.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ac2.project_ac2.entity.CodeCurso;
import com.ac2.project_ac2.entity.Curso;

public class CursoTest {
	@Test
    void testCursoConstructorAndGetters() {
        CodeCurso code = new CodeCurso("CURSO123");
        Curso curso = new Curso(1L, code, "Matemática", "Curso de Matemática Avançada");

        assertEquals(1L, curso.getId());
        assertEquals(code, curso.getCode());
        assertEquals("Matemática", curso.getName());
        assertEquals("Curso de Matemática Avançada", curso.getDescription());
    }
	
	@Test
    void testCursoSetters() {
        Curso curso = new Curso();
        CodeCurso code = new CodeCurso("CURSO456");

        curso.setId(2L);
        curso.setCode(code);
        curso.setName("Física");
        curso.setDescription("Curso de Física Experimental");

        assertEquals(2L, curso.getId());
        assertEquals(code, curso.getCode());
        assertEquals("Física", curso.getName());
        assertEquals("Curso de Física Experimental", curso.getDescription());
    }
	
	@Test
    void testCodeCursoConstructorAndGetter() {
        CodeCurso codeCurso = new CodeCurso("CODE123");
        assertEquals("CODE123", codeCurso.getCode());
    }

    @Test
    void testCodeCursoSetter() {
        CodeCurso codeCurso = new CodeCurso();
        codeCurso.setCode("CODE456");
        assertEquals("CODE456", codeCurso.getCode());
    }
}
