package br.com.sysacademia.service;
import br.com.sysacademia.model.Instrutor;
import br.com.sysacademia.repository.InstrutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {
    private final InstrutorRepository instrutorRepository;

    public InstrutorService(InstrutorRepository instrutorRepository) {
        this.instrutorRepository = instrutorRepository;
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
}
