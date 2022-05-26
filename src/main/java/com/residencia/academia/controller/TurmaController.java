package com.residencia.academia.controller;

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

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;

	@GetMapping
	public ResponseEntity<List<Turma>> findAllTurma() {
		List<Turma> turmaList = turmaService.findAllTurma();
		return new ResponseEntity<>(turmaList, HttpStatus.OK);
	}

	@GetMapping("/dto/{id}")
	public ResponseEntity<TurmaDTO> findTurmaDTOById(@PathVariable Integer id) {
		TurmaDTO turmaDTO = turmaService.findTurmaDTOById(id);
		if (turmaDTO.getIdTurma() == null) {
			throw new NoSuchElementFoundException("Turma com id " + id + " não foi encontrado");
		} else {
			return new ResponseEntity<>(turmaDTO, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> findTurmaById(@PathVariable Integer id) {
		Turma turma = turmaService.findTurmaById(id);
		if (turma == null) {
			throw new NoSuchElementFoundException("Turma com id" + id + " não foi encontrada");
		} else {
			return new ResponseEntity<>(turma, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
		Turma turmaPost = turmaService.saveTurma(turma);
		return new ResponseEntity<>(turmaPost, HttpStatus.CREATED);

	}

	@PostMapping("/dto")
	public ResponseEntity<TurmaDTO> saveTurmaDTO(@RequestBody TurmaDTO turmaDTO) {
		TurmaDTO turmaPost = turmaService.saveTurmaDTO(turmaDTO);
		return new ResponseEntity<>(turmaPost, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Turma> updateTurma(@RequestBody Turma turma) {
		Turma turmaUpdate = turmaService.updateTurma(turma);
		return new ResponseEntity<>(turmaUpdate, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable Integer id) {
		Turma turma = turmaService.findTurmaById(id);
		if (turma == null) {
			throw new NoSuchElementFoundException("Turma com id" + id + " não foi encontrada para ser deletada");
		} else {
			turmaService.deleteTurma(id);
			return new ResponseEntity<>("Turma com id" + id + " deletada com sucesso.", HttpStatus.OK);
		}
	}
}