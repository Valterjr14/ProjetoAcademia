package main.java.com.exemplo.academia.model;
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

    public void imprimirAvaliacao(){
        System.out.println("Data: " + data);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + altura + " m");
        System.out.println("IMC: " + String.format("%.2f", imc));
        System.out.println("Percentual de Gordura: " + percentualGordura + "%");
    }
}


