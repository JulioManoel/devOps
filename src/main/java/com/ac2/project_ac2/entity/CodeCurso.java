package com.ac2.project_ac2.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CodeCurso {
    private String code;

    public CodeCurso() {}

    public CodeCurso(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}