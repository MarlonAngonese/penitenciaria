package com.penitenciaria.repository;

import org.springframework.data.repository.CrudRepository;

import com.penitenciaria.models.Condenados;


public interface CondenadosRepository extends CrudRepository<Condenados, String> {

	Iterable<Condenados> findAllByOrderByCodigoDesc();

	Condenados findByCodigo(long codigo);

}
