package com.alexalvesfd.algaworks.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexalvesfd.algaworks.domain.model.Estado;
import com.alexalvesfd.algaworks.domain.repository.EstadoRepository;

@Service
@Transactional
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> findAll() {
		List<Estado> findAll = estadoRepository.findAll();
		return findAll;
	}

	public Optional<Estado> findById(Long id) {
		Optional<Estado> findById = estadoRepository.findById(id);
		return findById;
	}

	public Estado save(Estado estado) {
		estado.setId(null);
		Estado save = estadoRepository.save(estado);
		return save;
	}

	public void deleteById(Long id) {
		estadoRepository.deleteById(id);
	}


}
