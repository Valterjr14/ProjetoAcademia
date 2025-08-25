package br.com.sysacademia.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity /* Indica que esta classe é uma entidade do JPA */
@Table(name="avaliacoes_fisicas")   /* Mapeia a tabela "avaliacoes_fisicas" no banco de dados */
public class AvaliacaoFisica {

    //Atributos da avaliação física
    @Id /* Indica que este atributo é a chave primária da entidade */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Indica que o valor da chave primária será gerado automaticamente pelo banco de dados */
    private Long id;
    private LocalDate data;
    private double percentualGordura;
    private double altura;
    private double peso;
    private double imc;
    @ManyToOne  /* Indica que uma avaliação física está associada a um aluno (Muitas avaliações para um Aluno) */
    @JoinColumn(name = "aluno_id")  /* Mapeia a coluna "aluno_id" na tabela "avaliacoes_fisicas" */
    private Aluno aluno;

    //Construtores
    public AvaliacaoFisica(){ }
    public AvaliacaoFisica(LocalDate data, double peso, double percentualGordura, double altura, Aluno aluno){
        this.data = data;
        this.peso= peso;
        this.altura = altura;
        this.percentualGordura = percentualGordura;
        this.aluno = aluno;
        calcularIMC();
    }

    //Método para calcular o IMC
    private void calcularIMC(){
        if (altura > 0) {
            imc = peso / (altura * altura);
        } else {
            imc = 0;
        }
    }

    //Getters e Setters
    public Long getId() {return id;}
    public LocalDate getData() {return data; }
    public double getPeso() {return peso; }
    public double getAltura() {return altura; }
    public double getImc() {return imc; }
    public double getPercentualGordura() {return percentualGordura;}
    public Aluno getAluno(){return aluno;}

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

    //Método para imprimir a avaliação
    public void imprimirAvaliacao() {
        System.out.println("Avaliação Física:");
        System.out.println("Data: " + data);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + altura + " m");
        System.out.println("IMC: " + String.format("%.2f", imc));
        System.out.println("Percentual de Gordura: " + percentualGordura + "%");
    }

    //Método toString
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
