package com.alexalvesfd.algaworks.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexalvesfd.algaworks.domain.model.Cozinha;
import com.alexalvesfd.algaworks.domain.repository.CozinhaRepository;

@Service
@Transactional
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public List<Cozinha> findAll() {
		List<Cozinha> findAll = cozinhaRepository.findAll();
		return findAll;
	}

	public Optional<Cozinha> findById(Long id) {
		Optional<Cozinha> findById = cozinhaRepository.findById(id);
		return findById;
	}

	public Cozinha save(Cozinha cozinha) {
		cozinha.setId(null);
		Cozinha save = cozinhaRepository.save(cozinha);
		return save;
	}

	public void deleteById(Long id) {
		cozinhaRepository.deleteById(id);
	}


}
