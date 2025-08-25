package br.com.sysacademia.model;

import jakarta.persistence.*;

//Entidade que representa um exercício em um treino
@Entity /* Indica que esta classe é uma entidade do JPA */
public class TreinoExercicio {
    //Atributos do exercício no treino
    @Id /* Identificador único do exercício no treino */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Geração automática do ID */
    private Long id;
    @ManyToOne  /* Relação muitos-para-um com a entidade Exercicio */
    private Exercicio exercicio;
    private int numRepeticoes;
    private int numSeries;
    @ManyToOne  /* Relação muitos-para-um com a entidade Treino */
    private Treino treino;

    //Construtores
    public TreinoExercicio() {}
    public TreinoExercicio(Exercicio exercicio, int numRepeticoes, int numSeries){
        this.exercicio = exercicio;
        this.numRepeticoes = numRepeticoes;
        this.numSeries = numSeries;
    }

    //Getters e Setters
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

    //Método toString com polimorfismo
    @Override
    public String toString(){
        return exercicio.getNome() + " | séries: " + numSeries + " | repetições: " + numRepeticoes;
    }
    
}
