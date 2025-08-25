package br.com.sysacademia.repository;

import br.com.sysacademia.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositório para a entidade Treino
@Repository /* Indica que esta interface é um repositório do Spring Data */
public interface TreinosRepository extends JpaRepository<Treino, Long> {
}
