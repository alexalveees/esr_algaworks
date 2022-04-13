package com.alexalvesfd.algaworks.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexalvesfd.algaworks.domain.model.Produto;
import com.alexalvesfd.algaworks.domain.repository.ProdutoRepository;
import com.alexalvesfd.algaworks.domain.service.exception.ObjectNotFoundException;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		List<Produto> findAll = produtoRepository.findAll();
		return findAll;
	}

	public Produto findById(Long id) {
		Optional<Produto> findById = produtoRepository.findById(id);
		return findById.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Produto save(Produto produto) {
		produto.setId(null);
		Produto save = produtoRepository.save(produto);
		return save;
	}

	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}

}
