package com.alexalvesfd.algaworks.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo")
public class Grupo {

	@Id
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "grupo_permissao", 
		joinColumns = @JoinColumn(name = "grupo_id"), 
		inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao> permissoens = new ArrayList<>();

	public Grupo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
