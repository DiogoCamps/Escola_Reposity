package com.escola.escolaProj.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    private String nome;
    @Column(unique = true)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "id")
    Turma turma;

    public Aluno(){

    }

    public Aluno(String nome, String cpf, Turma turma) {
        this.nome = nome;
        this.cpf = cpf;
        this.turma = turma;
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

    public Long getIdAluno() {
        return idAluno;
    }
}
