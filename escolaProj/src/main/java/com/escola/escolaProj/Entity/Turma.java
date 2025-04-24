package com.escola.escolaProj.Entity;

import com.escola.escolaProj.Entity.Aluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turma implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String sigla;
     @Column(unique = true)
     private Integer numeroSala;
     private String nome;
     private Professor professor;
     private List<Aluno> aluno;
}
