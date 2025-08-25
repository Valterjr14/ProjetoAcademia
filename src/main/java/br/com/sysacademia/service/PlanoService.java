package br.com.sysacademia.service;

import br.com.sysacademia.model.Plano;
import br.com.sysacademia.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {
    @Autowired
    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }
    @Transactional
    public Plano salvarPlano(Plano plano) {
        return planoRepository.save(plano);
    }
    @Transactional(readOnly = true)
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
