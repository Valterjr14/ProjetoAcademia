package br.com.sysacademia.controller;

import br.com.sysacademia.model.Treino;
import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.service.TreinoService;

import java.util.List;
import java.util.Scanner;

public class TreinoController {
    private TreinoService treinoService;
    private Scanner scanner;

    public TreinoController() {
        this.treinoService = new TreinoService();
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== MENU DE TREINOS ===");
            System.out.println("1 - Criar Treino");
            System.out.println("2 - Adicionar Exercício a Treino");
            System.out.println("3 - Exibir Treinos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    Treino novoTreino = criarTreino();
                    System.out.println("Treino criado com sucesso!");
                    break;
                case "2":
                    System.out.print("Informe a descrição do treino para adicionar exercício: ");
                    String descricao = scanner.nextLine();
                    Treino treino = buscarTreinoPorDescricao(descricao);
                    if (treino != null) {
                        adicionarExercicioAoTreino(treino);
                    } else {
                        System.out.println("Treino não encontrado!");
                    }
                    break;
                case "3":
                    exibirTreinos();
                    break;
                case "0":
                    System.out.println("Saindo do menu...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public Treino criarTreino() {
        System.out.println("=== Criar Novo Treino ===");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Nível de dificuldade: ");
        String nivel = scanner.nextLine();
        System.out.print("Duração (minutos): ");
        int duracao = Integer.parseInt(scanner.nextLine());

        Treino treino = new Treino(descricao, nivel, duracao);
        return treino;
    }

    public void adicionarExercicioAoTreino(Treino treino) {
        System.out.println("=== Adicionar Exercício ===");
        System.out.print("Nome do exercício: ");
        String nome = scanner.nextLine();

        Exercicio exercicio = new Exercicio(nome);

        System.out.print("Número de séries: ");
        int series = Integer.parseInt(scanner.nextLine());
        System.out.print("Número de repetições: ");
        int repeticoes = Integer.parseInt(scanner.nextLine());

        treinoService.adicionarExercicio(treino, exercicio, repeticoes, series);
        System.out.println("Exercício adicionado com sucesso!");
    }

    private List<Treino> treinosMemoria = new java.util.ArrayList<>();

    public void exibirTreinos() {
        if (treinosMemoria.isEmpty()) {
            System.out.println("Nenhum treino disponível!");
        } else {
            for (Treino t : treinosMemoria) {
                treinoService.exibirTreino(t);
                System.out.println("---------------------");
            }
        }
    }

    private Treino buscarTreinoPorDescricao(String descricao) {
        for (Treino t : treinosMemoria) {
            if (t.getDescricaoTreino().equalsIgnoreCase(descricao)) {
                return t;
            }
        }
        System.out.println("Treino não encontrado na memória!");
        return null;
    }
    
}
