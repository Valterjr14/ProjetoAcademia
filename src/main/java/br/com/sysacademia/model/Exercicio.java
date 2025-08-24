package br.com.sysacademia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Exercicio() {}

    public Exercicio(String nome) {this.nome = nome;}
    public Long getId() { return id;}
    public String getNome() {return nome;}
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return "Exercicio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
