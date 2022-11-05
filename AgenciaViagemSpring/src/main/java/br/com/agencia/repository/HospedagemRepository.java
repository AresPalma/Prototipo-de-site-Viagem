package br.com.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agencia.model.Hospedagem;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

	
}

