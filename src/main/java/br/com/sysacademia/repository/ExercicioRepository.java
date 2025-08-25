package br.com.sysacademia.repository;

import br.com.sysacademia.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

//Repositório para a entidade Exercicio
@Repository /* Indica que esta interface é um repositório do Spring Data */
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    Optional<Exercicio> findByNome(String nome);    /* Busca um exercício pelo nome */
}
