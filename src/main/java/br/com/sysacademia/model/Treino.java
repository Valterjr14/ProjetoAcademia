package br.com.sysacademia.model;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

//Entidade que representa um treino
@Entity /* Indica que esta classe é uma entidade do JPA */
@Table(name= "treinos") /* Indica que esta classe está mapeada para a tabela "treinos" */
public class Treino {
    //Atributos do treino
    @Id /* Identificador único do treino */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Geração automática do ID */
    private Long id;
    private String descricaoTreino, nivelDificuldade;
    private int duracaoMinutos;
    @ManyToOne(fetch = FetchType.LAZY)  /* Relação muitos-para-um com a entidade Aluno */
    @JoinColumn(name = "aluno_id")  /* Chave estrangeira que referencia o aluno */
    private Aluno aluno;
    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)    /* Relação um-para-muitos com a entidade TreinoExercicio */
    private List<TreinoExercicio> listaExercicios;

    //Construtores
    public Treino(){
        this.listaExercicios = new ArrayList<>();
    }

    public Treino(String descricaoTreino, String nivelDificuldade, int duracaoMinutos){
        this.descricaoTreino = descricaoTreino;
        this.nivelDificuldade = nivelDificuldade;
        this.duracaoMinutos = duracaoMinutos;
        this.listaExercicios = new ArrayList<>();
    }

    //Getters e Setters
    public Long getId(){ return id; }
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

    public Aluno getAluno(){
        return aluno;
    }

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }

    //Método para exibir resumo do treino
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