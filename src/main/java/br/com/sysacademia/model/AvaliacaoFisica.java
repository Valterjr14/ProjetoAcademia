package br.com.sysacademia.model;
import java.time.LocalDate;
import jakarta.persistence.*;
@Entity
@Table(name="avaliacoes_fisicas")

public class AvaliacaoFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private double percentualGordura;
    private double altura;
    private double peso;
    private double imc;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    public AvaliacaoFisica(){ }
    public AvaliacaoFisica(LocalDate data, double peso, double percentualGordura, double altura, Aluno aluno){
        this.data = data;
        this.peso= peso;
        this.altura = altura;
        this.percentualGordura = percentualGordura;
        this.aluno = aluno;
        calcularIMC();
    }

    private void calcularIMC(){
        if (altura > 0) {
            imc = peso / (altura * altura);
        } else {
            imc = 0;
        }
    }

    public Long getId() {return id;}
    public LocalDate getData() {return data; }
    public double getPeso() {return peso; }
    public double getAltura() {return altura; }
    public double getImc() {return imc; }
    public double getPercentualGordura() {return percentualGordura;}

    public void setAluno(Aluno aluno){this.aluno = aluno;}
    public void setPercentualGordura(double percentualGordura) { this.percentualGordura = percentualGordura; }
    public void setData(LocalDate data) { this.data = data; }
    public void setPeso(double peso) {
        this.peso = peso;
        calcularIMC();
    }
    public void setAltura(double altura) {
        this.altura = altura;
        calcularIMC();
    }
    public void imprimirAvaliacao() {
        System.out.println("Avaliação Física:");
        System.out.println("Data: " + data);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + altura + " m");
        System.out.println("IMC: " + String.format("%.2f", imc));
        System.out.println("Percentual de Gordura: " + percentualGordura + "%");
    }
    public String toString() {
        return "AvaliacaoFisica{" +
                "id=" + id +
                ", data=" + data +
                ", peso=" + peso +
                ", altura=" + altura +
                ", imc=" + String.format("%.2f", imc) +
                ", percentualGordura=" + percentualGordura +
                '}';
    }
}
