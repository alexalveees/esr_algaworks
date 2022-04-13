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

import com.alexalvesfd.algaworks.domain.model.Cozinha;
import com.alexalvesfd.algaworks.domain.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaService cozinhaService;

	@GetMapping
	public ResponseEntity<List<Cozinha>> findAll() {
		List<Cozinha> findAll = cozinhaService.findAll();
		if (findAll != null) {
			return ResponseEntity.ok().body(findAll);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Cozinha>> findById(@PathVariable Long id) {
		Optional<Cozinha> findById = cozinhaService.findById(id);
		if (findById.isPresent()) {
			return ResponseEntity.ok().body(findById);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	 
	@PostMapping
	public ResponseEntity<Cozinha> save(@RequestBody Cozinha cozinha) {
	    Cozinha save = cozinhaService.save(cozinha);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
	    cozinhaService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
