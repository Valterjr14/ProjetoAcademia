package br.com.sysacademia.repository;
import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.Instrutor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    Optional<Instrutor> findByEmail(String email);
}
