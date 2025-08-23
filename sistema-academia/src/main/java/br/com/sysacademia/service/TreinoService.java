package br.com.sysacademia.service;

import br.com.sysacademia.model.Treino;
import br.com.sysacademia.model.TreinoExercicio;
import br.com.sysacademia.model.Exercicio;

import java.util.List;

public class TreinoService {
    
    public void adicionarExercicio(Treino treino, Exercicio exercicio, int numRepeticoes, int numSeries){
        TreinoExercicio novoTreino = new TreinoExercicio(exercicio, numRepeticoes, numSeries);
        treino.getListaExercicios().add(novoTreino);
    }

    public void removerExercicio(TreinoExercicio exercicio){
        treino.setListaExercicios().remove(exercicio);
    }

    public void exibirTreino(Treino treino){
        System.out.println("Treino: " + treino.getDescricaoTreino());
        System.out.println("Nível de Dificuldade: " + treino.getNivelDificuldade());
        System.out.println("Duração: " + treino.getDuracaoMinutos() + "min");

        List<TreinoExercicio> lista = treino.getListaExercicios();
        if (lista.isEmpty()) {
            System.out.println("Nenhum exercício cadastrado neste treino.");
        } else {
            for (TreinoExercicio t : lista) {
                System.out.println("- " + t.getExercicio().getNome() 
                                   + " | Séries: " + t.getNumSeries() 
                                   + " | Repetições: " + t.getNumRepeticoes());
            }
        }
    }

}
