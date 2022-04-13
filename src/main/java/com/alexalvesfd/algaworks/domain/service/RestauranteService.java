package com.alexalvesfd.algaworks.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexalvesfd.algaworks.domain.model.Restaurante;
import com.alexalvesfd.algaworks.domain.repository.RestauranteRepository;

@Service
@Transactional
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	public List<Restaurante> findAll() {
		List<Restaurante> findAll = restauranteRepository.findAll();
		return findAll;
	}

	public Optional<Restaurante> findById(Long id) {
		Optional<Restaurante> findById = restauranteRepository.findById(id);
		return findById;
	}

	public Restaurante save(Restaurante restaurante) {
		restaurante.setId(null);
		Restaurante save = restauranteRepository.save(restaurante);
		return save;
	}

	public void deleteById(Long id) {
		restauranteRepository.deleteById(id);
	}


}
