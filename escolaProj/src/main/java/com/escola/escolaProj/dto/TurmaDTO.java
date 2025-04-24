package com.escola.escolaProj.dto;

import com.escola.escolaProj.Entity.Aluno;
import com.escola.escolaProj.Entity.Professor;
import com.escola.escolaProj.Entity.Aluno;
import com.escola.escolaProj.Entity.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDTO implements Serializable {
    private Long id;
    private String sigla;
    private Integer numeroSala;
    private String nome;
    private Professor professor;
    private List<Aluno> aluno;

  public Turma toTurma(){
      return new Turma(
              this.id = id,
              this.sigla = sigla,
              this.numeroSala = numeroSala,
              this.nome = nome,
              this.professor = professor,
              this.aluno = aluno
      );
  }
      public TurmaDTO fromTurma(Turma turma){
          return new TurmaDTO(
                  turma.getId(),
                  turma.getSigla(),
                  turma.getNumeroSala(),
                  turma.getNome(),
                  turma.getProfessor(),
                  turma.getAluno()
          );
  }

}
