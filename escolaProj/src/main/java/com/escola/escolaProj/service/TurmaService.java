package com.escola.escolaProj.service;

import com.escola.escolaProj.Entity.Turma;
import com.escola.escolaProj.dto.TurmaDTO;
import com.escola.escolaProj.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    public TurmaRepository turmaRepository;

    public List<Turma> getAll() {
        return turmaRepository.findAll();
    }
    //busca pelo id
    public Optional<TurmaDTO> getById(Long id){
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if(turmaOptional.isPresent()){
            TurmaDTO turmaDTO = new TurmaDTO();
            return Optional.of(turmaDTO.fromTurma(turmaOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    //busca pelo nome
    public List<Turma> getAllByNome(String nome){
        return turmaRepository.findAllByNome(nome);
    }

    //cria uma turma
    public TurmaDTO createTurma(TurmaDTO turmaDTO){
        Turma turma = turmaDTO.toTurma();
        turma = turmaRepository.save(turma);
        return turmaDTO.fromTurma(turma);
    }

    //atualiza os dados da turma menos os alunos
    public Optional<TurmaDTO> updateTurma(Long id, TurmaDTO turmaDTO) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if(turmaOptional.isPresent()){
            Turma turma = turmaOptional.get();
            turma.setSigla(turmaDTO.getSigla());
            turma.setNumeroSala(turmaDTO.getNumeroSala());
            turma.setNome(turmaDTO.getNome());
            turma.setProfessor(turmaDTO.getProfessor());

            turma = turmaRepository.save(turma);

            return Optional.of(turmaDTO.fromTurma(turma));
        }else {
            return Optional.empty();
        }
    }

    public  boolean delete(Long id){
        if(turmaRepository.existsById(id)){
            turmaRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
