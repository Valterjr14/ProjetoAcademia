package br.com.sysacademia.model;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePlano;
    @Column(name = "valor")
    private BigDecimal valor;
    private int duracaoMeses;

    public Plano(){}
    public Plano(String nomePlano, BigDecimal valor, int duracaoMeses){
        this.nomePlano = nomePlano;
        this.valor = valor;
        this.duracaoMeses = duracaoMeses;
    }

    public Long getId() {return id;}
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

    @Override
    public String toString(){
        return nomePlano + " (" + duracaoMeses + " meses) - R$ " + valor;
    }
}
