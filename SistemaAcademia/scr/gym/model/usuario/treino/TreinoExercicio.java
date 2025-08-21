package scr.gym.model.usuario.treino;

import scr.gym.model.usuario.exercicio.Exercicio;

public class TreinoExercicio {
    private Exercicio exercicio;
    private int numRepeticoes, numSeries;

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
    
}
