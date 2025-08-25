package br.com.sysacademia.service;

import br.com.sysacademia.model.Plano;
import br.com.sysacademia.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

//Serviço para a entidade Plano
@Service    /* Indica que esta classe é um serviço do Spring */
public class PlanoService {
    //Injeção de dependências
    @Autowired  /* Injeção de dependência do repositório de planos */
    private final PlanoRepository planoRepository;

    //Construtor
    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    //Método para salvar um plano
    @Transactional  /* Indica que este método deve ser executado dentro de uma transação */
    public Plano salvarPlano(Plano plano) {
        return planoRepository.save(plano);
    }

    //Método para listar todos os planos
    @Transactional(readOnly = true) /* Indica que este método é somente leitura */
    public List<Plano> listarPlanos() {
        return planoRepository.findAll();   /* Retorna a lista de todos os planos */
    }

    //Método para buscar um plano por ID
    public Optional<Plano> buscarPorId(Long id) {
        return planoRepository.findById(id);
    }

    //Método para deletar um plano
    public void deletarPlano(Long id) {
        planoRepository.deleteById(id);
    }
}
