package br.com.sysacademia.model;

import jakarta.persistence.*;

//Entidade que representa um exercício físico
@Entity /* Indica que esta classe é uma entidade do JPA */
@Table(name = "exercicios") /* Mapeia a tabela "exercicios" no banco de dados */
public class Exercicio {
    //Atributos do exercício
    @Id /* Indica que este atributo é a chave primária da entidade */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Indica que o valor da chave primária será gerado automaticamente pelo banco de dados */
    private Long id;
    private String nome;

    //Construtores
    public Exercicio() {}

    public Exercicio(String nome) {this.nome = nome;}

    //Getters e Setters
    public Long getId() { return id;}
    public String getNome() {return nome;}
    public void setNome(String nome) { this.nome = nome; }

    //Método toString
    @Override
    public String toString() {
        return "Exercicio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
