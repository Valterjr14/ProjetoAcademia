package br.com.sysacademia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recepcionistas")
public class Recepcionista extends Usuario{
    public Recepcionista(){
        super();
    }
    public Recepcionista(String nome, String email, String senha){
        super(nome, email, senha);
    }
}
