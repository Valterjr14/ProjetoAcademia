package br.com.sysacademia.repository;

import br.com.sysacademia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    // Método extra para buscar aluno pela matrícula
    Aluno findByMatricula(String matricula);
}