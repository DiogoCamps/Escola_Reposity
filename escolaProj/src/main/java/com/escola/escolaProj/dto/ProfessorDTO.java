package com.escola.escolaProj.dto;

import com.escola.escolaProj.Entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO implements Serializable {
    private Long id;
    private String nome;
    private String sobrenome;

    public Professor toProfessor(){
        return new Professor(
                this.id,
                this.nome,
                this.sobrenome
        );
    }

    public ProfessorDTO fromProfessor(Professor professor){
        return new ProfessorDTO(
                professor.getId(),
                professor.getNome(),
                professor.getSobrenome()
        );

    }

}
