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

import com.alexalvesfd.algaworks.domain.model.Estado;
import com.alexalvesfd.algaworks.domain.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {
		List<Estado> estado = estadoService.findAll();
		if (estado != null) {
			return ResponseEntity.ok().body(estado);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Estado>> findById(@PathVariable Long id) {
		Optional<Estado> findById = estadoService.findById(id);
		if (findById.isPresent()) {
			return ResponseEntity.ok().body(findById);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	 
	@PostMapping
	public ResponseEntity<Estado> save(@RequestBody Estado estado) {
		Estado save = estadoService.save(estado);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		estadoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
