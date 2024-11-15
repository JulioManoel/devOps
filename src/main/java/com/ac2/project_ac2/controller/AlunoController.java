package com.ac2.project_ac2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.project_ac2.DTO.AlunoCursoRequestDTO;
import com.ac2.project_ac2.entity.Aluno;
//import com.ac2.project_ac2.service.AlunoCursoService;
import com.ac2.project_ac2.service.AlunoService;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/alunos")
public class AlunoController extends BaseController<Aluno, Long> {		
	@Autowired
	private AlunoService alunoService;
	
	public AlunoController(AlunoService alunoService) {
        super(alunoService);
    }
	
	@PostMapping("/increver")
	public ResponseEntity<String> inscrever(@RequestBody AlunoCursoRequestDTO request) {
		try {
			alunoService.inscrever(request.getAlunoId(), request.getCursoId());
            return ResponseEntity.status(201).body("Aluno inscrito no curso com sucesso.");
        } catch (EntityNotFoundException e) {
        	return ResponseEntity.notFound().build();
        }
	}
}
