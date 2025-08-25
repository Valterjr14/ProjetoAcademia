package br.com.sysacademia.repository;

import br.com.sysacademia.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositório para a entidade Plano
@Repository /* Indica que esta interface é um repositório do Spring Data */
public interface PlanoRepository extends JpaRepository<Plano, Long> {
    boolean existsByNomePlano(String nomePlano);    /* Verifica se um plano existe pelo nome */
}
