package main.java.com.exemplo.academia.model;

public class Plano {
    private String nomePlano;
    private double valor;
    private int duracaoMeses;

    public Plano(String nomePlano, double valor, int duracaoMeses){
        this.nomePlano = nomePlano;
        this.valor = valor;
        this.duracaoMeses = duracaoMeses;
    }

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
