package br.com.sysacademia.service;

import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.repository.ExercicioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {
    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }
    public Exercicio salvar(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }
    public List<Exercicio> listarTodos() {
        return exercicioRepository.findAll();
    }
    public Optional<Exercicio> buscarPorId(Long id) {
        return exercicioRepository.findById(id);
    }
    public void deletar(Long id) {
        exercicioRepository.deleteById(id);
    }
    public Optional<Exercicio> buscarPorNome(String nome) {
        return exercicioRepository.findByNome(nome);
    }
}
