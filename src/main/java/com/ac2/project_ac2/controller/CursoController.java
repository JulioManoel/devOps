package com.ac2.project_ac2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.project_ac2.entity.Curso;
import com.ac2.project_ac2.service.CursoService;

@CrossOrigin
@RestController
@RequestMapping("/cursos")
public class CursoController extends BaseController<Curso, Long> {
	public CursoController(CursoService cursoService) {
        super(cursoService);
    }
}
