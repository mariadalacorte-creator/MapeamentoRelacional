package com.projetoMapeamentoRelacional.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projetoMapeamentoRelacional.entity.Aluno;
import com.projetoMapeamentoRelacional.entity.Turma;
import com.projetoMapeamentoRelacional.repository.TurmaRepository;

@Service
public class TurmaService {
private final TurmaRepository turmaRepository;
	
	public TurmaService (TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	public List <Turma> buscarTodos(){
		return turmaRepository.findAll();
	}
	
	public Turma buscarPorId(Long id) {
		Optional <Turma> turma = turmaRepository.findById(id);
		return turma.orElse(null);
	}
	
	//query method
	public List<Turma> buscarTurmaPorNome (String nome){
		return turmaRepository.findByNome(nome);
	}
	
	public Turma salvarTurma (Turma atTurma) {
		return turmaRepository.save(atTurma);
	}
	
	public Turma atualizarTurma(Long id, Turma atTurma) {
		Optional<Turma> exeTurma = turmaRepository.findById(id);
		if (exeTurma.isPresent()) {
		atTurma.setId(id);
		return turmaRepository.save(atTurma);
		} else {
		return null;
		}
		}
		
	public Boolean deletarTurma (Long id) {
		Optional <Turma> exeTurma = turmaRepository.findById(id);
		if (exeTurma.isPresent()) {
			turmaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
