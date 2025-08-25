package br.com.sysacademia.model;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name= "treinos")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricaoTreino, nivelDificuldade;
    private int duracaoMinutos;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreinoExercicio> listaExercicios;

    public Treino(){
        this.listaExercicios = new ArrayList<>();
    }

    public Treino(String descricaoTreino, String nivelDificuldade, int duracaoMinutos){
        this.descricaoTreino = descricaoTreino;
        this.nivelDificuldade = nivelDificuldade;
        this.duracaoMinutos = duracaoMinutos;
        this.listaExercicios = new ArrayList<>();
    }

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

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
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