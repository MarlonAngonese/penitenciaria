package com.penitenciaria.repository;

import org.springframework.data.repository.CrudRepository;

import com.penitenciaria.models.Policiais;

public interface PoliciaisRepository extends CrudRepository<Policiais, String> {
	Policiais findByCodigo(long codigo);

	Iterable<Policiais> findAllByOrderByCodigoDesc();
}
