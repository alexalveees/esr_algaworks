package com.alexalvesfd.algaworks.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexalvesfd.algaworks.domain.model.Cidade;
import com.alexalvesfd.algaworks.domain.model.Estado;
import com.alexalvesfd.algaworks.domain.repository.CidadeRepository;
import com.alexalvesfd.algaworks.domain.repository.EstadoRepository;

@Service
@Transactional
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	

	public List<Cidade> findAll() {
		List<Cidade> findAll = cidadeRepository.findAll();
		return findAll;
	}

	public Optional<Cidade> findById(Long id) {
		Optional<Cidade> findById = cidadeRepository.findById(id);
		return findById;
	}

	public Cidade save(Cidade cidade) {
		cidade.setId(null);

		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.getById(estadoId);

		cidade.setEstado(estado);

		Cidade save = cidadeRepository.save(cidade);
		return save;
	}

	public void deleteById(Long id) {
		cidadeRepository.deleteById(id);
	}

}
