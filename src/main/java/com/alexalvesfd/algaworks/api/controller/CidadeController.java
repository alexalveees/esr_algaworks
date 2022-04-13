package com.alexalvesfd.algaworks.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexalvesfd.algaworks.domain.model.Cidade;
import com.alexalvesfd.algaworks.domain.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> findAll = cidadeService.findAll();
		if (findAll != null) {
			return ResponseEntity.ok().body(findAll);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Optional<Cidade> findById = cidadeService.findById(id);
		if (findById.isPresent()) {
			return ResponseEntity.ok().body(findById.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	 
	@PostMapping
	public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
		Cidade save = cidadeService.save(cidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		cidadeService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
