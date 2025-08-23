package br.com.sysacademia.model;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio {
    private String nome;

    public Exercicio(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    
    private static ArrayList<Exercicio> catalogo = new ArrayList<>();

    public static void exerciciosCatalogo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos exercícios deseja adicionar ao catálogo?");
        int qtd = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtd; i++){
            System.out.print("Digite o nome do exercício" + (i+1) + ": ");
            String nome = sc.nextLine();
            catalogo.add(new Exercicio(nome));
        }
        sc.close();
        System.out.println("Exercícios adicionados com sucesso!");
    }

    public static void mostrarCatalogo(){
        if (catalogo.isEmpty()) {
            System.out.println("O catálogo está vazio!");
        } else {
            System.out.println("CATÁLOGO DE EXERCÍCIOS");
            for (int i = 0; i < catalogo.size(); i++){
                System.out.println((i+1) + ". " + catalogo.get(i).getNome());
            }
        }
    }
    public static ArrayList<Exercicio> getCatalogo(){
        return catalogo;
    }
    
}
