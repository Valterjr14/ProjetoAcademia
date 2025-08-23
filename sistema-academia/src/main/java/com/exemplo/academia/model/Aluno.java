package main.java.com.exemplo.academia.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private Plano plano;
    private String matricula, cpf;
    private List<Treino> treinos;
    private List<AvaliacaoFisica> avaliacoes;

    public Aluno(String nome, String email, String senha, String matricula, String cpf, Plano plano) {
        super(nome, email, senha);
        this.matricula = matricula;
        this.cpf = cpf;
        this.plano = plano;
        this.treinos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarTreino(Treino treino) {
        treinos.add(treino);
    }

    public void adicionarAvaliacao(AvaliacaoFisica avaliacao){
        avaliacoes.add(avaliacao);
    }

    public List<Treino> getTreinos(){
        return treinos;
    }
    public List<AvaliacaoFisica> getAvaliacaoFisicas(){
        return avaliacoes;
    }

    public Plano getPlano(){
        return plano;
    }

    public void mostrarAvaliacoes(){
        System.out.println("Histórico de Avaliações de " + nome + ":");
        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação registrada.");
        } else {
            for (AvaliacaoFisica a : avaliacoes) {
                a.imprimirAvaliacao();
                System.out.println("-------------------");
            }
        }
    }

    public String getMatricula() {
        return matricula;
    }
    public List<AvaliacaoFisica> getAvaliacoes() {return new ArrayList<>(avaliacoes); }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", matricula='" + matricula + '\'' +
                ", Plano='" + plano.getNomePlano() + '\'' +
                ", Peso='" + peso + '\'' +
                ", Altura='" + altura + '\'' +
                '}';
    }
}
