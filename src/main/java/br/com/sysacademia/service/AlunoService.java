package br.com.sysacademia.service;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.repository.AlunoRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository repository;
    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }

    public Aluno salvarAluno(Aluno alu){
        System.out.println("Salvando aluno: " + alu.getNome());
        return repository.save(alu);
    }
    public List<Aluno> listarAlunos(){
        System.out.println("Lista de todos os alunos:");
        return repository.findAll();
    }
    public Aluno buscarPorMatricula(String mat){
        System.out.println("Busca de aluno pela matrícula:" + mat);
        return repository.findByMatricula(mat);
    }
    public void deletarAluno(Long id){
        System.out.println("Deletando aluno");
    }
    public Optional<Aluno> buscarPorId(Long id){
        return repository.findById(id);
    }

}
