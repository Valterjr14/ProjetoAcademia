package br.com.sysacademia.repository;

import br.com.sysacademia.model.TreinoExercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositório para a entidade TreinoExercicio
@Repository /* Indica que esta interface é um repositório do Spring Data */
public interface TreinoExercicioRepository extends JpaRepository<TreinoExercicio, Long>{
    
}
