package br.com.agencia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agencia.model.Cliente;

@Repository
public interface UsuarioRepository extends JpaRepository<Cliente, Long> {

	
}


