package scr.gym;

import scr.gym.model.usuario.aluno.Aluno;
import scr.gym.model.usuario.instrutor.Instrutor;
import scr.gym.model.usuario.plano.Plano;
import scr.gym.model.usuario.treino.Treino;
import scr.gym.model.usuario.exercicio.Exercicio;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Aluno usuario = new Aluno("Pedro", "pedro@example.com", "senha123", "12345");
        Instrutor instrutor = new Instrutor("Maria", "maria@example.com", "senha456", "Musculação");
        Treino treino = new Treino("Treino para hipertrofia", "Iniciante", 60);
        Plano plano = new Plano("Premium", 500.0, 12);
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Senha: " + usuario.getSenha());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Nome: " + instrutor.getNome());
        System.out.println("Email: " + instrutor.getEmail());
        System.out.println("Senha: " + instrutor.getSenha());
        System.out.println("Especialidade: " + instrutor.getEspecialidade());
        System.out.println("Plano de Treino: " + plano.getNomePlano());
        System.out.println("Valor do Plano: R$" + plano.getValor());
        System.out.println("Duração em meses: " + plano.getDuracaoMeses());
        System.out.println("Descrição do treino: " + treino.getDescricaoTreino());
        System.out.println("Nivel de dificuldade do treino: " + treino.getNivelDificuldade());
        System.out.println("Deuração em minutos do treino: " + treino.getDuracaoMinutos());*/

        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=== MENU EXERCÍCIOS ===");
            System.out.println("1 - Adicionar exercícios ao catálogo");
            System.out.println("2 - Mostrar catálogo existente");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch(opcao) {
                case 1:
                    Exercicio.exerciciosCatalogo();
                    break;
                case 2:
                    Exercicio.mostrarCatalogo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);

        sc.close();
    }
}
