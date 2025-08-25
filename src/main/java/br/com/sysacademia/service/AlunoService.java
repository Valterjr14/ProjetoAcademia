package br.com.sysacademia.service;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

//Serviço para a entidade Aluno
@Service    /* Indica que esta classe é um serviço do Spring */
public class AlunoService {
    //Injeção de dependências
    private final AlunoRepository repository;
    private final PasswordEncoder passwordEncoder;

    //Construtor
    public AlunoService(AlunoRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    //Método para salvar um aluno
    public Aluno salvarAluno(Aluno alu){
        alu.setSenha(passwordEncoder.encode(alu.getSenha()));   //Criptografa a senha do aluno
        System.out.println("Salvando aluno: " + alu.getNome()); //Exibe o nome do aluno que está sendo salvo
        return repository.save(alu);    //Salva o aluno no repositório
    }

    //Método para listar todos os alunos
    public List<Aluno> listarAlunos(){
        System.out.println("Lista de todos os alunos:");
        return repository.findAll();    //Retorna todos os alunos
    }

    //Método para buscar um aluno pela matrícula
    public Aluno buscarPorMatricula(String mat){
        System.out.println("Busca de aluno pela matrícula:" + mat);
        return repository.findByMatricula(mat); //Busca o aluno pelo número da matrícula
    }
    
    //Método para deletar um aluno
    public void deletarAluno(Long id) {
        //Verifica se o aluno existe antes de tentar deletar
        if (repository.existsById(id)) {
            repository.deleteById(id);  //Deleta o aluno pelo ID
        }
    }

    //Método para buscar um aluno pelo ID
    public Optional<Aluno> buscarPorId(Long id){
        return repository.findById(id);  //Busca o aluno pelo ID
    }

    //Método para buscar um aluno pelo email
    public Optional<Aluno> buscarPorEmail(String email) {
        return repository.findByEmail(email);   //Busca o aluno pelo email
    }

    //Método para buscar alunos pelo nome
    public List<Aluno> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);  //Busca alunos pelo nome
    }
}
