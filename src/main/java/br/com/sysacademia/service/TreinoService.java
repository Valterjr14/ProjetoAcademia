package br.com.sysacademia.service;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.model.Treino;
import br.com.sysacademia.model.TreinoExercicio;
import br.com.sysacademia.repository.AlunoRepository;
import br.com.sysacademia.repository.ExercicioRepository;
import br.com.sysacademia.repository.TreinosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    private final TreinosRepository treinosRepository;
    private final AlunoRepository alunoRepository;
    private final ExercicioRepository exercicioRepository;

    public TreinoService(TreinosRepository treinosRepository, AlunoRepository alunoRepository, ExercicioRepository exercicioRepository) {
        this.treinosRepository = treinosRepository;
        this.alunoRepository = alunoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    public List<Treino> listarTodos() {
        return treinosRepository.findAll();
    }

    public Optional<Treino> buscarPorId(Long id) {
        return treinosRepository.findById(id);
    }

    @Transactional
    public Treino salvar(Treino treino) {
        return treinosRepository.save(treino);
    }
    
    @Transactional
    public Treino criarTreinoParaAluno(Treino treino, Long alunoId) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);
        if (alunoOpt.isPresent()) {
            treino.setAluno(alunoOpt.get());
            return treinosRepository.save(treino);
        }
        return null; 
    }

    @Transactional
    public void adicionarExercicioAoTreino(Long treinoId, Long exercicioId, int series, int repeticoes) {
        Optional<Treino> treinoOpt = treinosRepository.findById(treinoId);
        Optional<Exercicio> exercicioOpt = exercicioRepository.findById(exercicioId);

        if (treinoOpt.isPresent() && exercicioOpt.isPresent()) {
            Treino treino = treinoOpt.get();
            Exercicio exercicio = exercicioOpt.get();

            TreinoExercicio treinoExercicio = new TreinoExercicio(exercicio, repeticoes, series);
            treinoExercicio.setTreino(treino); // Importante: Link bidirecional

            treino.getListaExercicios().add(treinoExercicio);
            treinosRepository.save(treino);
        }
    }
    
    public void deletar(Long id) {
        treinosRepository.deleteById(id);
    }
}
