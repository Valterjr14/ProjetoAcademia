package main.java.com.exemplo.academia.model;

import java.util.List;
import java.util.ArrayList;

public class Treino {
    private String descricaoTreino, nivelDificuldade;
    private int duracaoMinutos;
    private List<TreinoExercicio> listaExercicios;

    public Treino(String descricaoTreino, String nivelDificuldade, int duracaoMinutos){
        this.descricaoTreino = descricaoTreino;
        this.nivelDificuldade = nivelDificuldade;
        this.duracaoMinutos = duracaoMinutos;
        this.listaExercicios = new ArrayList<>();
    }

    public String getDescricaoTreino(){
        return descricaoTreino;
    }

    public void setDescricaoTreino(String descricaoTreino){
        this.descricaoTreino = descricaoTreino;
    }

    public String getNivelDificuldade(){
        return nivelDificuldade;
    }

    public void setNivelDificuldade(String nivelDificuldade){
        this.nivelDificuldade = nivelDificuldade;
    }

    public int getDuracaoMinutos(){
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos){
        this.duracaoMinutos = duracaoMinutos;
    }

    public void adicionarExercicio(Exercicio exercicio, int numRepeticoes, int numSeries){
        TreinoExercicio novoTreino = new TreinoExercicio(exercicio, numRepeticoes, numSeries);
        listaExercicios.add(novoTreino);
    }

    public void removerExercicio(TreinoExercicio exercicio){
        listaExercicios.remove(exercicio);
    }

    public void exibirTreino(){
        System.out.println("Treino: " + descricaoTreino);
        System.out.println("Nivel Dificuldade: " + nivelDificuldade);
        System.out.println("Duração em minutos: " + duracaoMinutos + "min");
        for(TreinoExercicio t : listaExercicios){
            System.out.println("- " + t.getExercicio().getNome() 
                                + " | séries: " + t.getNumSeries() 
                                + " | Número de repetições: " + t.getNumRepeticoes());
        }
    }

    public List<TreinoExercicio> getListaExercicios(){
        return listaExercicios;
    }
}
