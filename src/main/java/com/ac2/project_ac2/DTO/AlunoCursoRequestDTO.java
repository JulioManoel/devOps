package com.ac2.project_ac2.DTO;

public class AlunoCursoRequestDTO {
	private Long alunoId;
    private Long cursoId;

    public AlunoCursoRequestDTO() {}
    
    public AlunoCursoRequestDTO(Long alunoId, Long cursoId) {
    	this.alunoId = alunoId;
    	this.cursoId = cursoId;
    }
    
    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
