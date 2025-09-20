package br.com.sysacademia.model;

import jakarta.persistence.*;

//Classe abstrata que representa um usuário do sistema
@MappedSuperclass   /* Indica que esta classe é uma superclasse mapeada do JPA */
public abstract class Usuario {
    //Atributos comuns a todos os usuários
    @Id /* Identificador único do usuário */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Geração automática do ID */
    protected Long id;
    protected String nome;
    protected String email;
    protected String senha;

    //Construtores
    public Usuario() {}
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    //Getters e Setters
    public Long getId(){ 
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNome() {
        return nome;
    }   
    public void setNome(String nome) {
        this.nome = nome;
    }       
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }   

    //Método toString com polimorfismo
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}