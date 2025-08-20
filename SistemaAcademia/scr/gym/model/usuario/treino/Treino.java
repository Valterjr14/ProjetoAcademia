package scr.gym.model.usuario.treino;

import java.util.List;
import java.util.ArrayList;

public class Treino {
    private String descricaoTreino, nivelDificuldade;
    private int duracaoMinutos;
    //private List<> listaExercicios;

    public Treino(String descricaoTreino, String nivelDificuldade, int duracaoMinutos){
        this.descricaoTreino = descricaoTreino;
        this.nivelDificuldade = nivelDificuldade;
        this.duracaoMinutos = duracaoMinutos;
        //this.listaExercicios = new ArrayList<>();
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

    public void adicionarExercicio(){}
    public void removerExercicio(){}
    public void exibirTreino(){}

    /*public List<> getListaExercicios(){
        return listaExercicios;
    }*/
}
