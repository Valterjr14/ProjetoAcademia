package br.com.sysacademia.service;
import br.com.sysacademia.model.AvaliacaoFisica;
import br.com.sysacademia.repository.AvaliacaoFisicaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//Serviço para a entidade AvaliacaoFisica
@Service    /* Indica que esta classe é um serviço do Spring */
public class AvaliacaoFisicaService {
    //Injeção de dependências
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    //Construtor
    public AvaliacaoFisicaService(AvaliacaoFisicaRepository avaliacaoFisicaRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
    }

    //Método para salvar uma avaliação física
    public AvaliacaoFisica salvar(AvaliacaoFisica avaliacao) {
        return avaliacaoFisicaRepository.save(avaliacao);
    }

    //Método para listar todas as avaliações físicas
    public List<AvaliacaoFisica> listarTodos() {
        return avaliacaoFisicaRepository.findAll();
    }

    //Método para buscar uma avaliação física pelo ID
    public Optional<AvaliacaoFisica> buscarPorId(Long id) {
        return avaliacaoFisicaRepository.findById(id);
    }

    //Método para deletar uma avaliação física
    public void deletar(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
