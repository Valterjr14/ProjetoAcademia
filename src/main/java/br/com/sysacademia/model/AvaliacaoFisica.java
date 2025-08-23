package br.com.sysacademia.model;
import java.time.LocalDate;

public class AvaliacaoFisica {
    private LocalDate data;
    private double percentualGordura;
    private double altura;
    private double peso;
    private double imc;

    public AvaliacaoFisica(LocalDate data, double peso, double percentualGordura, double altura){
        this.data = data;
        this.peso= peso;
        this.altura = altura;
        this.percentualGordura = percentualGordura;
        calcularIMC();
    }

    private void calcularIMC(){
        if (altura > 0) {
            imc = peso / (altura * altura);
        } else {
            imc = 0;
        }
    }

    public LocalDate getData() {return data; }
    public double getPeso() {return peso; }
    public double getAltura() {return altura; }
    public double getImc() {return imc; }
    public double getPercentualGordura() {return percentualGordura;}

    public String exibirResumoAvaliacao(){
        return "Data: " + data + " | Peso: " + peso + "kg | Altura: " + altura + "m | IMC: " + String.format("%.2f", imc) + " | Percentual de Gordura: " + percentualGordura + "%";
    }
}


