package com.penitenciaria.repository;

import org.springframework.data.repository.CrudRepository;

import com.penitenciaria.models.Sentencas;

public interface SentencasRepository extends CrudRepository<Sentencas, String> {
	Sentencas findByCodigo(long codigo);

	Iterable<Sentencas> findAllByOrderByCodigoDesc();
}
