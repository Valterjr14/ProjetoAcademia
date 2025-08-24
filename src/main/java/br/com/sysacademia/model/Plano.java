package br.com.sysacademia.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePlano;
    private double valor;
    private int duracaoMeses;

    public Plano(){}
    public Plano(String nomePlano, double valor, int duracaoMeses){
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

    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
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
