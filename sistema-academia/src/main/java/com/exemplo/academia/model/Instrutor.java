package main.java.com.exemplo.academia.model;

import java.util.ArrayList;
import java.util.List;

public class Instrutor extends Usuario {
    private String especialidade;
    private List<Aluno> alunos;

    public Instrutor(String nome, String email, String senha, String especialidade) {
        super(nome, email, senha);
        this.especialidade = especialidade;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void criarTreino(Aluno aluno, Treino treino) {
        aluno.adicionarTreino(treino);
    }

    public void realizarAvaliacao(Aluno aluno, AvaliacaoFisica avaliacao) {
        aluno.adicionarAvaliacao(avaliacao);
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
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
