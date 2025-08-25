package br.com.sysacademia.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Entidade que representa um instrutor, herda da classe Usuario
@Entity /* Indica que esta classe é uma entidade do JPA */
@Table(name = "instrutores")    /* Mapeia a tabela "instrutores" no banco de dados */
public class Instrutor extends Usuario {
    //Atributos do instrutor
    private String especialidade;
    @OneToMany(mappedBy = "instrutor")  /* Indica que um instrutor pode ter vários alunos */
    private List<Aluno> alunos = new ArrayList<>(); /* Lista de alunos sob a responsabilidade do instrutor */

    //Construtores
    public Instrutor() {
        super();
    }
    public Instrutor(String nome, String email, String senha, String especialidade) {
        super(nome, email, senha);
        this.especialidade = especialidade;
    }

    //Métodos para adicionar alunos
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    //Métodos para criar treino
    public void criarTreino(Aluno aluno, Treino treino) {
        aluno.adicionarTreino(treino);
        treino.setAluno(aluno);
    }

    //Métodos para realizar avaliação
    public void realizarAvaliacao(Aluno aluno, AvaliacaoFisica avaliacao) {
        aluno.adicionarAvaliacoes(avaliacao);
        avaliacao.setAluno(aluno);
    }

    //Getters e Setters
    public List<Aluno> getAlunos() {
        return alunos;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    //Método toString
    @Override
    public String toString() {
        return "Instrutor{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
