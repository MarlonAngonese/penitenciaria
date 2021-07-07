package com.penitenciaria.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Condenados implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
		
	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private String dataNascimento;
	private String nomeMae;
	
	@ManyToOne
	private Ocupacoes ocupacoes;
	
	@ManyToOne
	private Sentencas sentencas;
	
	private String antecedenteCriminal;
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Ocupacoes getOcupacoes() {
		return ocupacoes;
	}

	public void setOcupacoes(Ocupacoes ocupacoes) {
		this.ocupacoes = ocupacoes;
	}

	public Sentencas getSentencas() {
		return sentencas;
	}

	public void setSentencas(Sentencas sentencas) {
		this.sentencas = sentencas;
	}

	public String getAntecedenteCriminal() {
		return antecedenteCriminal;
	}

	public void setAntecedenteCriminal(String antecedenteCriminal) {
		this.antecedenteCriminal = antecedenteCriminal;
	}
	
	

}
