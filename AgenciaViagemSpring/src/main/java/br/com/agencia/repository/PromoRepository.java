package br.com.agencia.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agencia.model.Promo;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long> {

}




