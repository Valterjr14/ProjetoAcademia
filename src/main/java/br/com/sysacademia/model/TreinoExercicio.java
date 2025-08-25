package br.com.sysacademia.model;

import jakarta.persistence.*;

@Entity
public class TreinoExercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Exercicio exercicio;
    private int numRepeticoes;
    private int numSeries;
    @ManyToOne
    private Treino treino;

    public TreinoExercicio() {}
    public TreinoExercicio(Exercicio exercicio, int numRepeticoes, int numSeries){
        this.exercicio = exercicio;
        this.numRepeticoes = numRepeticoes;
        this.numSeries = numSeries;
    }

    public Exercicio getExercicio(){
        return exercicio;
    }

    public int getNumRepeticoes(){
        return numRepeticoes;
    }

    public void setNumRepeticoes(int numRepeticoes){
        this.numRepeticoes = numRepeticoes;
    }

    public int getNumSeries(){
        return numSeries;
    }

    public void setNumSeries(int numSeries){
        this.numSeries = numSeries;
    }

    public void setTreino(Treino treino){
        this.treino = treino;
    }

    @Override
    public String toString(){
        return exercicio.getNome() + " | séries: " + numSeries + " | repetições: " + numRepeticoes;
    }
    
}
