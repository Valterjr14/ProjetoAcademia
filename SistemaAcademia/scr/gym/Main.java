package scr.gym;

import scr.gym.model.usuario.aluno.Aluno;
import scr.gym.model.usuario.avaliacaofisica.AvaliacaoFisica;
import scr.gym.model.usuario.instrutor.Instrutor;
import scr.gym.model.usuario.plano.Plano;
import scr.gym.model.usuario.treino.Treino;
import scr.gym.model.usuario.exercicio.Exercicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plano plano1 = new Plano("Premium", 500.0, 6);
        Plano plano2 = new Plano("Basico", 200.0, 3);
        Plano plano3 = new Plano("Premium Plus", 1500.0, 12);
        
        Scanner sc = new Scanner(System.in);

        List<Aluno> alunos = new ArrayList<>();
        List<Instrutor> instrutores = new ArrayList<>();
        List<Treino> treinos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== MENU EXERCÍCIOS ===");
            System.out.println("1 - Adicionar exercícios ao catálogo");
            System.out.println("2 - Mostrar catálogo existente");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Cadastrar Instrutor");
            System.out.println("5 - Criar Treino");
            System.out.println("6 - Avaliar Aluno");
            System.out.println("7 - Lista de Treinos");
            System.out.println("8 - Lista de Avaliações");
            System.out.println("9 - Listar Treinos (de um aluno escolhido)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch(opcao) {
                case 1:
                    Exercicio.exerciciosCatalogo();
                    break;
                case 2:
                    Exercicio.mostrarCatalogo();
                    break;
                case 3:
                    System.out.println("\n>>> CADASTRO DE ALUNO <<<");
                    System.out.println("Nome: ");
                    String nomeAluno = sc.nextLine();
                    System.out.println("E-mail: ");
                    String emailAluno = sc.nextLine();
                    System.out.println("Senha: ");
                    String senhaAluno = sc.nextLine();
                    System.out.println("Matricula: ");
                    String matriculaAluno = sc.nextLine();
                    System.out.println("Peso(kg): ");
                    double peso = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura: ");
                    double altura = Double.parseDouble(sc.nextLine());

                    System.out.println("Qual o plano desejado? : ");
                    System.out.println("\n>>> PLANOS DISPONIVEIS <<<");
                    System.out.println(plano1.getNomePlano() + ", " + plano2.getNomePlano() + ", " + plano3.getNomePlano());
                    System.out.println("\nDigite 1 para plano Premium, 2 para premium Básico ou 3 para Premium Plus");
                    int escolha = Integer.parseInt(sc.nextLine());
                    Plano planoEscolhido = null;

                    if(escolha == 1){ 
                        planoEscolhido = plano1; 
                    } else if(escolha == 2){
                        planoEscolhido = plano2;
                    } else {
                        planoEscolhido = plano3;
                    }
                    
                    Aluno novoAluno = new Aluno(nomeAluno, emailAluno, senhaAluno, matriculaAluno, peso, altura, planoEscolhido, null, null);
                    alunos.add(novoAluno);
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;
                case 4:
                    System.out.println("\n>>> CADASTRO DE INSTRUTOR <<<");
                    System.out.println("Nome: ");
                    String nomeInstrutor = sc.nextLine();
                    System.out.println("E-mail: ");
                    String emailInstrutor = sc.nextLine();
                    System.out.println("Senha: ");
                    String senhaInstrutor = sc.nextLine();
                    System.out.println("Especialidade: ");
                    String especialidade = sc.nextLine();

                    Instrutor novoInstrutor = new Instrutor(nomeInstrutor, emailInstrutor, senhaInstrutor, especialidade);
                    instrutores.add(novoInstrutor);
                    System.out.println("Instrutor cadastrado com sucesso!");
                    break;
                case 5:
                    System.out.println("\n>>> CRIAR TREINO <<<");
                    if(alunos.isEmpty() || instrutores.isEmpty()){
                        System.out.println("É necessário ter pelo menos 1 aluno e 1 instrutor cadastrado");
                        break;
                    }
                    System.out.println("Criar Plano de Treino: ");
                    System.out.println("Escolha o aluno: ");
                    for(int i = 0; i < alunos.size(); i++){
                        System.out.println((i + 1) + " - " + alunos.get(i).getNome());
                    }
                    int alunoEscolhidoTreino = Integer.parseInt(sc.nextLine()) - 1;

                    System.out.println("Descrição do Treino: ");
                    String descricaoTreino = sc.nextLine();
                    System.out.println("Nivel: ");
                    String nivelDificuldade = sc.nextLine();
                    System.out.println("Duração em minutos: ");
                    int duracaoMinutos = Integer.parseInt(sc.nextLine());

                    Treino novoTreino = new Treino(descricaoTreino, nivelDificuldade, duracaoMinutos);
                    
                    System.out.println("MOSTRANDO EXERCICIOS NO CATALOGO: ");
                    Exercicio.mostrarCatalogo();
                    
                    boolean continuar = true;
                    while(continuar){
                        System.out.println("Escolha os exercicios (selecione 0 para finalizar a seleção): ");
                        int escolhaE = Integer.parseInt(sc.nextLine());
                        if(escolhaE == 0){
                            break;
                        }
                        Exercicio exercicio = Exercicio.getCatalogo().get(escolhaE - 1);


                        System.out.println("Número de séries: ");
                        int numSeries = Integer.parseInt(sc.nextLine());
                        System.out.println("Número de repetições: ");
                        int numRepeticoes = Integer.parseInt(sc.nextLine());

                        novoTreino.adicionarExercicio(exercicio, numRepeticoes, numSeries);
                    }
                    treinos.add(novoTreino);

                    Aluno alunoSelecionado = alunos.get(alunoEscolhidoTreino);
                    alunoSelecionado.adicionarTreino(novoTreino);

                    System.out.println("Treino criado com sucesso!");
                    novoTreino.exibirTreino();
                    break;
                case 6:
                    if(alunos.isEmpty() || instrutores.isEmpty()){
                        System.out.println("É necessário ter pelo menos 1 aluno e 1 instrutor cadastrado");
                        break;
                    }
                    System.out.println("\n>>> AVALIAR ALUNO <<<");
                    System.out.println("Escolha o aluno");
                    for(int i = 0; i < alunos.size(); i++){
                        System.out.println((i + 1) + " - " + alunos.get(i).getNome());
                    }
                    int alunoEscolhidoAvaliacao = Integer.parseInt(sc.nextLine()) - 1;

                    System.out.println("Peso(kg): ");
                    double pesoAluno = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura(cm): ");
                    double alturaAluno = Double.parseDouble(sc.nextLine());
                    System.out.println("Percentual de Gordura: ");
                    double percentualAluno = Double.parseDouble(sc.nextLine());

                    AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica(null, pesoAluno, percentualAluno, alturaAluno);
                    alunos.get(alunoEscolhidoAvaliacao).adicionarAvaliacao(novaAvaliacao);
                    System.out.println("Avaliação registrada com sucesso!");
                    break;
                case 7:
                    if(treinos.isEmpty()){
                        System.out.println("Nenhum treino cadastrado.");
                    } else {
                        System.out.println("\n >>> TREINOS CADASTRADOS <<< ");
                        for(int i = 0; i < treinos.size(); i++){
                            System.out.println((i + 1) + " - " + treinos.get(i).getDescricaoTreino());
                            treinos.get(i).exibirTreino();
                        }
                    }
                    break;
                case 8:
                    if(alunos.isEmpty()){
                        System.out.println("Nenhum aluno cadastrado");
                    } else {
                        System.out.println("Escolha o aluno para ver a avaliação: ");
                        for(int i = 0; i < alunos.size(); i++){
                            System.out.println((i + 1) + " - " + alunos.get(i).getNome());
                        }
                        int escolhaAluno = Integer.parseInt(sc.nextLine()) - 1;

                        List<AvaliacaoFisica> listaAvalicoes = alunos.get(escolhaAluno).getAvaliacoes();
                        if(listaAvalicoes ==  null || listaAvalicoes.isEmpty()){
                            System.out.println("Nenhuma avaliação registrada para esse aluno");
                        } else {
                            System.out.println("\n>>> AVALIAÇÕES DE " + alunos.get(escolhaAluno).getNome() + "<<<");
                            for(int i = 0; i < listaAvalicoes.size(); i++){
                                AvaliacaoFisica a = listaAvalicoes.get(i);
                                System.out.println((i + 1) + " - Peso: " + a.getPeso() + "kg | Altura: " + a.getAltura() + "cm | Percentual de Gordura: " + a.getPercentualGordura() + "% | IMC: " + a.getImc());
                            }
                        }
                    }
                    break;
                case 9:
                    if(alunos.isEmpty()){
                        System.out.println("Nenhum aluno cadastrado.");
                        break;
                    }
                    System.out.println("Escolha o aluno para ver seu(s) treino(s)");
                    for(int i = 0; i < alunos.size(); i++){
                        System.out.println((i + 1) + " - " + alunos.get(i).getNome());
                    }
                    int treinoEscolhidoAluno = Integer.parseInt(sc.nextLine());
                    Aluno alunoSelecionadoTreino = alunos.get(treinoEscolhidoAluno - 1);

                    List<Treino> treinosAluno = alunoSelecionadoTreino.getTreinos();
                    if(treinosAluno == null || treinosAluno.isEmpty()){
                        System.out.println("Nenhum treino registrado para esse aluno");
                    } else {
                        System.out.println("\n>>> TREINOS DE " + alunoSelecionadoTreino.getNome() + " <<<");
                        for(int i = 0; i < treinosAluno.size(); i++){
                            System.out.println((i + 1) + " - " + treinosAluno.get(i).getDescricaoTreino());
                            treinosAluno.get(i).exibirTreino();
                        }
                    }
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
