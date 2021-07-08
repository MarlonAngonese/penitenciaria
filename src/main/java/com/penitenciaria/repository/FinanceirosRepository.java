package com.penitenciaria.repository;

import org.springframework.data.repository.CrudRepository;

import com.penitenciaria.models.Financeiros;

public interface FinanceirosRepository extends CrudRepository<Financeiros, String> {
	Financeiros findByCodigo(long codigo);

	Iterable<Financeiros> findAllByOrderByCodigoDesc();
}
