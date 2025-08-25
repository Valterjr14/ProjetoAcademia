package br.com.sysacademia.repository;

import br.com.sysacademia.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositório para a entidade AvaliacaoFisica
@Repository /* Indica que esta interface é um repositório do Spring Data */
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
}
