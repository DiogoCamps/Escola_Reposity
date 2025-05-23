package com.escola.escolaProj.controller;

import com.escola.escolaProj.Entity.Aluno;
import com.escola.escolaProj.dto.AlunoDTO;
import com.escola.escolaProj.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAll(@RequestParam(required = false) String cpf){
        if(cpf != null && !cpf.isEmpty()){
            return alunoService.getAllAlunosCPF(cpf);
        }
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getById(@PathVariable Long id){
        Optional<AlunoDTO> alunoDTOOptional = alunoService.getById(id);
        if(alunoDTOOptional.isPresent()){
            return ResponseEntity.ok(alunoDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> create(@RequestBody AlunoDTO alunoDTO){
        AlunoDTO aluno = alunoService.createAluno(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO){
        Optional<AlunoDTO> alunoDTOOptional = alunoService.updateAluno(id, alunoDTO);
        if(alunoDTOOptional.isPresent()){
            return ResponseEntity.ok(alunoDTOOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(alunoService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
