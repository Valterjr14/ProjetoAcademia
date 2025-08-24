package br.com.sysacademia.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instrutores")
public class Instrutor extends Usuario {
    private String especialidade;
    @OneToMany
    private List<Aluno> alunos = new ArrayList<>();

    public Instrutor() {
        super();
    }
    public Instrutor(String nome, String email, String senha, String especialidade) {
        super(nome, email, senha);
        this.especialidade = especialidade;
    }
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    public void criarTreino(Aluno aluno, Treino treino) {
        aluno.adicionarTreino(treino);
    }
    public void realizarAvaliacao(Aluno aluno, AvaliacaoFisica avaliacao) {
        aluno.adicionarAvaliacoes(avaliacao);
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
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
