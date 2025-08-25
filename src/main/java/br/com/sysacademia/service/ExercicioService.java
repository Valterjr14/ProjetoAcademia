package br.com.sysacademia.service;

import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.repository.ExercicioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//Serviço para a entidade Exercicio
@Service    /* Indica que esta classe é um serviço do Spring */
public class ExercicioService {
    //Injeção de dependências
    private final ExercicioRepository exercicioRepository;

    //Construtor
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    //Método para salvar um exercício
    public Exercicio salvar(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    //Método para listar todos os exercícios
    public List<Exercicio> listarTodos() {
        return exercicioRepository.findAll();
    }

    //Método para buscar um exercício por ID
    public Optional<Exercicio> buscarPorId(Long id) {
        return exercicioRepository.findById(id);
    }

    //Método para deletar um exercício
    public void deletar(Long id) {
        exercicioRepository.deleteById(id);
    }

    //Método para buscar um exercício por nome
    public Optional<Exercicio> buscarPorNome(String nome) {
        return exercicioRepository.findByNome(nome);
    }
}
