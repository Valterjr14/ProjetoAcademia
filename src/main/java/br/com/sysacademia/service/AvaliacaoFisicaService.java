package br.com.sysacademia.service;
import br.com.sysacademia.model.AvaliacaoFisica;
import br.com.sysacademia.repository.AvaliacaoFisicaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public AvaliacaoFisicaService(AvaliacaoFisicaRepository avaliacaoFisicaRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
    }

    public AvaliacaoFisica salvar(AvaliacaoFisica avaliacao) {
        return avaliacaoFisicaRepository.save(avaliacao);
    }

    public List<AvaliacaoFisica> listarTodos() {
        return avaliacaoFisicaRepository.findAll();
    }

    public Optional<AvaliacaoFisica> buscarPorId(Long id) {
        return avaliacaoFisicaRepository.findById(id);
    }

    public void deletar(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
