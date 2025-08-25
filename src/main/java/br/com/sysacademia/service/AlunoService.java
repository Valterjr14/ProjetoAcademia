package br.com.sysacademia.service;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository repository;
    private final PasswordEncoder passwordEncoder;
    public AlunoService(AlunoRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Aluno salvarAluno(Aluno alu){
        alu.setSenha(passwordEncoder.encode(alu.getSenha()));
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
    public void deletarAluno(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
    public Optional<Aluno> buscarPorId(Long id){
        return repository.findById(id);
    }
    public Optional<Aluno> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
    public List<Aluno> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }
}
