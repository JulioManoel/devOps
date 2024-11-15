package com.ac2.project_ac2.controller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import com.ac2.project_ac2.controller.AlunoController;
import com.ac2.project_ac2.entity.Aluno;
import com.ac2.project_ac2.factory.AlunoFactory;
import com.ac2.project_ac2.service.AlunoService;

@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private AlunoService alunoService;
	
	@Test
    public void testGetUsers() throws Exception {
		Aluno mockAluno = AlunoFactory.build(1L, "Julio", "julio@gmail.com");
        
		
        List<Aluno> mockAlunos = List.of(mockAluno);
        when(alunoService.all()).thenReturn(mockAlunos);

        mockMvc.perform(MockMvcRequestBuilders.get("/alunos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Julio"))
                .andExpect(jsonPath("$[0].email.address").value("julio@gmail.com"));
    }
}
