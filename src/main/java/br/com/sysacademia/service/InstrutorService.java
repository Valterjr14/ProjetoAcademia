package br.com.sysacademia.service;
import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.Instrutor;
import br.com.sysacademia.repository.InstrutorRepository;
import br.com.sysacademia.repository.AlunoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {
    private final InstrutorRepository instrutorRepository;
    private final AlunoRepository alunoRepository;

    public InstrutorService(InstrutorRepository instrutorRepository, AlunoRepository alunoRepository) {
        this.instrutorRepository = instrutorRepository;
        this.alunoRepository = alunoRepository;
    }
    public Instrutor salvar(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }
    public List<Instrutor> listarTodos() {
        return instrutorRepository.findAll();
    }
    public Optional<Instrutor> buscarPorId(Long id) {
        return instrutorRepository.findById(id);
    }
    public void deletar(Long id) {
        instrutorRepository.deleteById(id);
    }
    @Transactional
    public boolean adicionarAluno(Long instrutorId, Long alunoId) {
        Optional<Instrutor> instrutorOptional = instrutorRepository.findById(instrutorId);
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);

        if (instrutorOptional.isPresent() && alunoOptional.isPresent()) {
            Instrutor instrutor = instrutorOptional.get();
            Aluno aluno = alunoOptional.get();
            instrutor.adicionarAluno(aluno);
            instrutorRepository.save(instrutor);
            return true;
        }
        return false;
    }
    public List<Aluno> listarAlunosInstrutor(Long instrutorId){
        Optional<Instrutor> instrutor = instrutorRepository.findById(instrutorId);
        return instrutor.map(Instrutor::getAlunos).orElse(null);
    }
}
