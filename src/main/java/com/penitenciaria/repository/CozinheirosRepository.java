package com.penitenciaria.repository;

import org.springframework.data.repository.CrudRepository;

import com.penitenciaria.models.Cozinheiros;

public interface CozinheirosRepository extends CrudRepository<Cozinheiros, String> {

	Iterable<Cozinheiros> findAllByOrderByCodigoDesc();

	Cozinheiros findByCodigo(long codigo);

}
