package br.com.agencia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agencia.model.Companhias;

@Repository
public interface CompanhiasRepository extends JpaRepository<Companhias, Long> {

}
