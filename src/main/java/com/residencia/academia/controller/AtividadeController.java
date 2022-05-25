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

import com.residencia.academia.dto.AtividadeDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.AtividadeService;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
	@Autowired
	private AtividadeService atividadeService;

	@GetMapping
	public ResponseEntity<List<Atividade>> findAllAtividade() {
		List<Atividade> atividadeList = atividadeService.findAllAtividade();
		return new ResponseEntity<>(atividadeList, HttpStatus.OK);
	}

	@GetMapping("/dto/{id}")
	public ResponseEntity<AtividadeDTO> findAtividadeDTOById(@PathVariable Integer id) {
		AtividadeDTO atividadeDTO = atividadeService.findAtividadeDTOById(id);
		if (atividadeDTO.getIdAtividade() == null) {
			throw new NoSuchElementFoundException("Atividade com id " + id + " não foi encontrado");
		} else {
			return new ResponseEntity<>(atividadeDTO, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Atividade> findAtividadeById(@PathVariable Integer id) {
		Atividade atividade = atividadeService.findAtividadeById(id);
		if (atividade == null) {
			throw new NoSuchElementFoundException("Atividade com id " + id + " não foi encontrada");
		} else {
			return new ResponseEntity<>(atividade, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Atividade> saveAtividade(@RequestBody Atividade atividade) {
		Atividade atividadePost = atividadeService.saveAtividade(atividade);
		return new ResponseEntity<>(atividadePost, HttpStatus.CREATED);
	}

	@PostMapping("/dto")
	public ResponseEntity<Atividade> saveAtividadeDTO(@RequestBody AtividadeDTO atividadeDTO) {
		Atividade atividadePost = atividadeService.saveAtividadeDTO(atividadeDTO);
		return new ResponseEntity<>(atividadePost, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Atividade> updateAtividade(@RequestBody Atividade atividade) {
		Atividade atividadePut = atividadeService.updateAtividade(atividade);
		return new ResponseEntity<>(atividadePut, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAtividade(@PathVariable Integer id) {
		Atividade atividade = atividadeService.findAtividadeById(id);
		if (atividade == null) {
			throw new NoSuchElementFoundException("Atividade com id " + id + " não foi encontrada para ser deletada");
		} else {
			atividadeService.deleteAtividade(id);
			return new ResponseEntity<>("Atividade com id " + id + " deletada com sucesso.", HttpStatus.OK);
		}
	}

}
