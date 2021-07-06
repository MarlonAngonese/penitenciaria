package com.penitenciaria.models;

import javax.persistence.Entity;

@Entity
public class Cozinheiros extends Funcionarios {
	
	private static final long serialVersionUID = 1L;
	
	private String salario;
	private String cargo;
	private String hrInicio;
	private String hrFinal;
	
	public String getSalario() {
		return this.salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getCargo() {
		return this.cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getHrInicio() {
		return this.hrInicio;
	}
	public void setHrInicio(String hrInicio) {
		this.hrInicio = hrInicio;
	}
	public String getHrFinal() {
		return this.hrFinal;
	}
	public void setHrFinal(String hrFinal) {
		this.hrFinal = hrFinal;
	}
}