package com.ac2.project_ac2.controller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ac2.project_ac2.controller.CursoController;
import com.ac2.project_ac2.entity.Curso;
import com.ac2.project_ac2.factory.CursoFactory;
import com.ac2.project_ac2.service.CursoService;

@WebMvcTest(CursoController.class)
public class CursoControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private CursoService cursoService;
	
	@Test
    public void testGetUsers() throws Exception {
		Curso mockCurso = CursoFactory.build(1L, "Matematica", "MAT101");
        
		
        List<Curso> mockCursos = List.of(mockCurso);
        when(cursoService.all()).thenReturn(mockCursos);

        mockMvc.perform(MockMvcRequestBuilders.get("/cursos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Matematica"))
                .andExpect(jsonPath("$[0].code.code").value("MAT101"));
    }
}
