package br.com.andre.spring.data.repository;

import br.com.andre.spring.data.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {



}

