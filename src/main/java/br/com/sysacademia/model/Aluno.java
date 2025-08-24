package br.com.sysacademia.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="alunos")
public class Aluno extends Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treino> treinos;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvaliacaoFisica> avaliacoes;
    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

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
