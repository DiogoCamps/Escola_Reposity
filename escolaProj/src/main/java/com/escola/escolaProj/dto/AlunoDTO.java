package com.escola.escolaProj.dto;

import com.escola.escolaProj.Entity.Aluno;
import com.escola.escolaProj.Entity.Turma;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class AlunoDTO implements Serializable{
    private Long idAluno;
    private String nome;
    private String cpf;
    @JsonIgnore
    private Turma turma;

    public Aluno toAluno() {
        return new Aluno(
                this.idAluno,
                this.nome,
                this.cpf,
                this.turma
        );
    }


    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(Long turma_id) {
        this.turma_id = turma_id;
    }
}
