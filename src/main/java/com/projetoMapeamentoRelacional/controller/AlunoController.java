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

import com.projetoMapeamentoRelacional.entity.Aluno;
import com.projetoMapeamentoRelacional.service.AlunoService;

@RestController
@RequestMapping("/aluno")
   public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	
	public AlunoController (AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
	Aluno aluno = alunoService.buscarPorId(id);
	if (aluno != null) {
	return ResponseEntity.ok(aluno);
	} else {
	return ResponseEntity.notFound().build();
	}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aluno>> buscarTodos() {
	List<Aluno> aluno = alunoService.buscarTodos();
	return ResponseEntity.ok(aluno);
	}

	@PostMapping("/")
	public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) {
	Aluno salvarAluno = alunoService.salvarAluno(aluno);
	return ResponseEntity.status(HttpStatus.CREATED).body(salvarAluno);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
	Aluno atualizarAluno = alunoService.atualizarAluno(id, aluno);
	if (atualizarAluno != null) {
	return ResponseEntity.ok(atualizarAluno);
	} else {
	return ResponseEntity.notFound().build();
	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> deletarAluno(@PathVariable Long id) {
	boolean apagar = alunoService.deletarAluno(id);
	if (apagar) {
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	} else {
	return ResponseEntity.notFound().build();
	}
	}
}
