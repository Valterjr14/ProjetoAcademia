package br.com.sysacademia.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

// Entidade que representa um aluno, herda da classe Usuario
@Entity /* Indica que esta classe é uma entidade do JPA */
@Table(name="alunos")   /* Mapeia a tabela "alunos" no banco de dados */
public class Aluno extends Usuario {

    // Atributos do aluno
    private String matricula;
    private String cpf;
    @ManyToOne  /* Indica que um aluno está associado a um plano (Muitos alunos para um Plano) */
    @JoinColumn(name = "plano_id")  /* Mapeia a coluna "plano_id" na tabela "alunos" */
    private Plano plano;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true) /* Indica que um aluno pode ter vários treinos (Um aluno para muitos treinos) */
    private List<Treino> treinos;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true) /* Indica que um aluno pode ter várias avaliações (Um aluno para muitas avaliações) */
    private List<AvaliacaoFisica> avaliacoes;
    @ManyToOne  /* Indica que um aluno está associado a um instrutor (Muitos alunos para um Instrutor) */
    @JoinColumn(name = "instrutor_id")  /* Mapeia a coluna "instrutor_id" na tabela "alunos" */
    private Instrutor instrutor;

    // Construtores
    public Aluno() {
        super();
        this.treinos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    public Aluno(String nome, String email, String senha, String matricula, String cpf, Plano plano) {
        super(nome, email, senha);
        this.matricula = matricula;
        this.cpf = cpf;
        this.plano = plano;
        this.treinos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Plano getPlano() { return plano; }
    public void setPlano(Plano plano) { this.plano = plano; }

    public void setInstrutor(Instrutor instrutor){this.instrutor = instrutor;}

    public List<Treino> getTreinos() { return treinos; }
    public void adicionarTreino(Treino treino) { treinos.add(treino); }

    public List<AvaliacaoFisica> getAvaliacoes() { return new ArrayList<>(avaliacoes); }
    public void adicionarAvaliacoes(AvaliacaoFisica avaliacao) { avaliacoes.add(avaliacao); }

    //Método para mostrar as avaliações
    public void mostrarAvaliacoes() {
        System.out.println("Histórico de Avaliações de " + getNome() + ":");
        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação registrada.");
        } else {
            for (AvaliacaoFisica a : avaliacoes) {
                a.imprimirAvaliacao();
                System.out.println("-------------------");
            }
        }
    }

    //Método toString que usa polimorfismo
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cpf='" + cpf + '\'' +
                ", plano='" + (plano != null ? plano.getNomePlano() : "sem plano") + '\'' +
                ", treinos=" + treinos.size() +
                ", avaliacoes=" + avaliacoes.size() +
                '}';
    }
}
