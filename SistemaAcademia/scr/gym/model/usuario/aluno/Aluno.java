package scr.gym.model.usuario.aluno;

import scr.gym.model.usuario.Usuario;
import scr.gym.model.usuario.avaliacaofisica.AvaliacaoFisica;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private List<AvaliacaoFisica> avaliacoes;

    public Aluno(String nome, String email, String senha, String matricula) {
        super(nome, email, senha);
        this.matricula = matricula;
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarAvaliacao(AvaliacaoFisica avaliacao){
        avaliacoes.add(avaliacao);
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
                '}';
    }
}
