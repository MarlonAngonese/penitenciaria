package com.penitenciaria.repository;

import org.springframework.data.repository.CrudRepository;

import com.penitenciaria.models.Ocupacoes;

public interface OcupacoesRepository extends CrudRepository<Ocupacoes, String> {
	Ocupacoes findByCodigo(long codigo);
}
