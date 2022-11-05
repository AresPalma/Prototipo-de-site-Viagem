package br.com.agencia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agencia.model.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}

