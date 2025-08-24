package br.com.sysacademia.service;
import br.com.sysacademia.model.Plano;
import br.com.sysacademia.repository.PlanoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {
    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }
    public Plano salvarPlano(Plano plano) {
        return planoRepository.save(plano);
    }
    public List<Plano> listarPlanos() {
        return planoRepository.findAll();
    }
    public Optional<Plano> buscarPorId(Long id) {
        return planoRepository.findById(id);
    }
    public void deletarPlano(Long id) {
        planoRepository.deleteById(id);
    }
}
