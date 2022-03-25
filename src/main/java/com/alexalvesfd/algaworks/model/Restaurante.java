package com.alexalvesfd.algaworks.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESTAURANTE")
	private Long id;
	
	@Column(name= "NOME")
	private String nome;
	
	@Column(name = "TAXA_FRETE")
	private BigDecimal taxaFrete;
	
	@Column(name = "ATIVO")
	private Boolean ativo;
	
	@Column(name = "ABERTO")
	private Boolean aberto;
	
	@Column(name = "DATA_CADASTRO")
	private LocalDate dataCadastro;
	
	@Column(name = "DATA_ATUALIZAÇÃO")
	private LocalDate dataAtualização;
	
	@ManyToOne
	@JoinColumn(name = "COZINHA_ID")
	private Cozinha cozinha;
	
	@ManyToOne
	@JoinColumn(name = "FORMA_PAGAMENTO_ID")
	private FormaPagamento formaPagamento;
	
	public Restaurante() {
		
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

	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}

	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getAberto() {
		return aberto;
	}

	public void setAberto(Boolean aberto) {
		this.aberto = aberto;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAtualização() {
		return dataAtualização;
	}

	public void setDataAtualização(LocalDate dataAtualização) {
		this.dataAtualização = dataAtualização;
	}

	public Cozinha getCozinha() {
		return cozinha;
	}

	public void setCozinha(Cozinha cozinha) {
		this.cozinha = cozinha;
	}
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nome=" + nome + ", taxaFrete=" + taxaFrete + ", ativo=" + ativo
				+ ", aberto=" + aberto + ", dataCadastro=" + dataCadastro + ", dataAtualização=" + dataAtualização
				+ ", cozinha=" + cozinha + ", formaPagamento=" + formaPagamento + "]";
	}

	
		
}
