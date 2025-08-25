package br.com.sysacademia.repository;

import br.com.sysacademia.model.Aluno;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmail(String email);

    // Método extra para buscar aluno pela matrícula
    Aluno findByMatricula(String matricula);
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}