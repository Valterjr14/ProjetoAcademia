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

//Serviço para a entidade Treino
@Service    /* Indica que esta classe é um serviço do Spring */
public class TreinoService {
    //Injeção de dependências
    private final TreinosRepository treinosRepository;
    private final AlunoRepository alunoRepository;
    private final ExercicioRepository exercicioRepository;

    //Construtor
    public TreinoService(TreinosRepository treinosRepository, AlunoRepository alunoRepository, ExercicioRepository exercicioRepository) {
        this.treinosRepository = treinosRepository;
        this.alunoRepository = alunoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    //Método para listar todos os treinos
    public List<Treino> listarTodos() {
        return treinosRepository.findAll();
    }

    //Método para buscar um treino por ID
    @Transactional  /* Indica que este método deve ser executado dentro de uma transação */
    public Optional<Treino> buscarPorId(Long id) {
        return treinosRepository.findById(id);
    }

    //Método para salvar um treino
    @Transactional  /* Indica que este método deve ser executado dentro de uma transação */
    public Treino salvar(Treino treino) {
        return treinosRepository.save(treino);
    }
    
    //Método para criar um treino para um aluno
    @Transactional  /* Indica que este método deve ser executado dentro de uma transação */
    public Treino criarTreinoParaAluno(Treino treino, Long alunoId) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);   /* Busca o aluno pelo ID */
        //Verifica se o aluno existe
        if (alunoOpt.isPresent()) {
            treino.setAluno(alunoOpt.get());    /* Define o aluno do treino */
            return treinosRepository.save(treino);  /* Salva o treino no repositório */
        }
        return null; 
    }

    //Método para adicionar um exercício a um treino
    @Transactional  /* Indica que este método deve ser executado dentro de uma transação */
    public void adicionarExercicioAoTreino(Long treinoId, Long exercicioId, int series, int repeticoes) {
        Optional<Treino> treinoOpt = treinosRepository.findById(treinoId);  /* Busca o treino pelo ID */
        Optional<Exercicio> exercicioOpt = exercicioRepository.findById(exercicioId);   /* Busca o exercício pelo ID */
        //Verifica se o treino e o exercício existem
        if (treinoOpt.isPresent() && exercicioOpt.isPresent()) {
            Treino treino = treinoOpt.get();    /* Obtém o treino */
            Exercicio exercicio = exercicioOpt.get();   /* Obtém o exercício */

            TreinoExercicio treinoExercicio = new TreinoExercicio(exercicio, repeticoes, series);   /* Cria a associação entre treino e exercício */
            treinoExercicio.setTreino(treino);  /* Define o treino na associação */

            treino.getListaExercicios().add(treinoExercicio);   /* Adiciona o exercício ao treino */
            treinosRepository.save(treino); /* Salva o treino atualizado no repositório */
        }
    }
    
    //Método para deletar um treino
    public void deletar(Long id) {
        treinosRepository.deleteById(id);
    }
}
