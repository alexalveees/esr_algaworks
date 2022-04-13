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

import com.alexalvesfd.algaworks.domain.model.Restaurante;
import com.alexalvesfd.algaworks.domain.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@GetMapping
	public ResponseEntity<List<Restaurante>> findAll() {
		List<Restaurante> findAll = restauranteService.findAll();
		if (findAll != null) {
			return ResponseEntity.ok().body(findAll);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Restaurante>> findById(@PathVariable Long id) {
		Optional<Restaurante> findById = restauranteService.findById(id);
		if (findById.isPresent()) {
			return ResponseEntity.ok().body(findById);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	 
	@PostMapping
	public ResponseEntity<Restaurante> save(@RequestBody Restaurante restaurante) {
		Restaurante save = restauranteService.save(restaurante);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		restauranteService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
