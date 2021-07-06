package com.penitenciaria.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sentencas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	
	private String artigo;
	private String descricao;
	private String anoSaida;
	private String visitas;
	private String semiAberto;
	
	public String getArtigo() {
		return artigo;
	}
	public void setArtigo(String artigo) {
		this.artigo = artigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAnoSaida() {
		return anoSaida;
	}
	public void setAnoSaida(String anoSaida) {
		this.anoSaida = anoSaida;
	}
	public String isVisitas() {
		return visitas;
	}
	public void setVisitas(String visitas) {
		this.visitas = visitas;
	}
	public String isSemiAberto() {
		return semiAberto;
	}
	public void setSemiAberto(String semiAberto) {
		this.semiAberto = semiAberto;
	}

}
