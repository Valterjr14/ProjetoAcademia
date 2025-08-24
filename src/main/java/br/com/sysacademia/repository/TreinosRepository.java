package br.com.sysacademia.repository;

import br.com.sysacademia.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinosRepository extends JpaRepository<Treino, Long> {
}
