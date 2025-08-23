package br.com.sysacademia.model;

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

    public String exibirResumoTreino(){
        return descricaoTreino + " (" + nivelDificuldade + ") - " + duracaoMinutos + " min";
    }

    public List<TreinoExercicio> getListaExercicios(){
        return listaExercicios;
    }

    public void setListaExericios(List<TreinoExercicio> listaExercicios){
        this.listaExercicios = listaExercicios;
    }
}
