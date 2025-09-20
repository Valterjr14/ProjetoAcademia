package br.com.sysacademia.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

// Entidade que representa um plano
@Entity /* Indica que esta classe é uma entidade do JPA */
public class Plano {
    // Atributos do plano
    @Id /* Identificador único do plano */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Geração automática do ID */
    private Long id;
    private String nomePlano;
    @Column(name = "valor") /* Valor do plano */
    private BigDecimal valor;
    private int duracaoMeses;

    //Construtores
    public Plano(){}
    public Plano(String nomePlano, BigDecimal valor, int duracaoMeses){
        this.nomePlano = nomePlano;
        this.valor = valor;
        this.duracaoMeses = duracaoMeses;
    }

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomePlano(){
        return nomePlano;
    }

    public void setNomePlano(String nomePlano){
        this.nomePlano = nomePlano;
    }

    public BigDecimal getValor(){
        return valor;
    }

    public void setValor(BigDecimal valor){
        this.valor = valor;
    }

    public int getDuracaoMeses(){
        return duracaoMeses;
    }

    public void setDuracaoMeses(int duracaoMeses){
        this.duracaoMeses = duracaoMeses;
    }

    //Método toString com polimorfismo
    @Override
    public String toString(){
        return nomePlano + " (" + duracaoMeses + " meses) - R$ " + valor;
    }
}
