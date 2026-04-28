package com.projetoMapeamentoRelacional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoMapeamentoRelacional.entity.Turma;
import com.projetoMapeamentoRelacional.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	
	private TurmaController (TurmaService turmaService) {
		this.turmaService = turmaService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
	Turma turma = turmaService.buscarPorId(id);
	if (turma != null) {
	return ResponseEntity.ok(turma);
	} else {
	return ResponseEntity.notFound().build();
	}
	}

	@GetMapping("/")
	public ResponseEntity<List<Turma>> buscarTodos() {
	List<Turma> turma = turmaService.buscarTodos();
	return ResponseEntity.ok(turma);
	}

	@PostMapping("/")
	public ResponseEntity<Turma> salvarTurma(@RequestBody Turma turma) {
	Turma salvarTurma = turmaService.salvarTurma(turma);
	return ResponseEntity.status(HttpStatus.CREATED).body(salvarTurma);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Turma> atualizarTurma(@PathVariable Long id, @RequestBody Turma turma) {
	Turma atualizarTurma = turmaService.atualizarTurma(id, turma);
	if (atualizarTurma != null) {
	return ResponseEntity.ok(atualizarTurma);
	} else {
	return ResponseEntity.notFound().build();
	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Turma> deletarTurma(@PathVariable Long id) {
	boolean apagar = turmaService.deletarTurma(id);
	if (apagar) {
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	} else {
	return ResponseEntity.notFound().build();
	}
	}

}
