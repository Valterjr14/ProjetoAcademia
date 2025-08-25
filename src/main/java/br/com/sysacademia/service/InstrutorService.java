package br.com.sysacademia.service;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.Instrutor;
import br.com.sysacademia.repository.InstrutorRepository;
import br.com.sysacademia.repository.AlunoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

//Serviço para a entidade Instrutor
@Service    /* Indica que esta classe é um serviço do Spring */
public class InstrutorService {
    //Injeção de dependências
    private final InstrutorRepository instrutorRepository;
    private final AlunoRepository alunoRepository;
    private final PasswordEncoder passwordEncoder;

    //Construtor
    public InstrutorService(InstrutorRepository instrutorRepository, AlunoRepository alunoRepository, PasswordEncoder passwordEncoder) {
        this.instrutorRepository = instrutorRepository;
        this.alunoRepository = alunoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Método para salvar um instrutor
    public Instrutor salvar(Instrutor instrutor) {
        instrutor.setSenha(passwordEncoder.encode(instrutor.getSenha()));
        return instrutorRepository.save(instrutor);
    }

    //Método para listar todos os instrutores
    public List<Instrutor> listarTodos() {
        return instrutorRepository.findAll();
    }

    //Método para buscar um instrutor por ID
    public Optional<Instrutor> buscarPorId(Long id) {
        return instrutorRepository.findById(id);
    }

    //Método para deletar um instrutor
    public void deletar(Long id) {
        instrutorRepository.deleteById(id);
    }

    //Método para adicionar um aluno a um instrutor
    @Transactional  /* Indica que este método deve ser executado dentro de uma transação */
    public boolean adicionarAluno(Long instrutorId, Long alunoId) {
        Optional<Instrutor> instrutorOptional = instrutorRepository.findById(instrutorId);  /* Busca o instrutor pelo ID */
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);  /* Busca o aluno pelo ID */
        // Verifica se ambos existem
        if (instrutorOptional.isPresent() && alunoOptional.isPresent()) {
            Instrutor instrutor = instrutorOptional.get();  /* Obtém o instrutor */
            Aluno aluno = alunoOptional.get();  /* Obtém o aluno */
            instrutor.adicionarAluno(aluno);    /* Adiciona o aluno ao instrutor */
            instrutorRepository.save(instrutor);    /* Salva as alterações no instrutor */
            return true;
        }
        return false;
    }

    //Método para listar alunos de um instrutor
    public List<Aluno> listarAlunosInstrutor(Long instrutorId){
        Optional<Instrutor> instrutor = instrutorRepository.findById(instrutorId);  /* Busca o instrutor pelo ID */
        return instrutor.map(Instrutor::getAlunos).orElse(null);    /* Retorna a lista de alunos do instrutor ou null */
    }

    //Método para buscar um instrutor por email
    public Optional<Instrutor> buscarPorEmail(String email) {
        return instrutorRepository.findByEmail(email);  /* Busca o instrutor pelo email */
    }
}
