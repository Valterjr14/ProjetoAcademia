package br.com.sysacademia.controller;

import br.com.sysacademia.model.*;


public class InstrutorController {
    private Instrutor instrutor;

    public InstrutorController(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno != null) {
            instrutor.adicionarAluno(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado com sucesso ao instrutor " + instrutor.getNome());
        } else {
            System.out.println("Erro: aluno inválido.");
        }
    }

    public void criarTreinoParaAluno(Aluno aluno, Treino treino) {
        if (aluno != null && treino != null) {
            instrutor.criarTreino(aluno, treino);
            System.out.println("Treino " + treino + " criado com sucesso para o aluno " + aluno.getNome());
        } else {
            System.out.println("Erro: aluno ou treino inválido.");
        }
    }

    public void realizarAvaliacaoParaAluno(Aluno aluno, AvaliacaoFisica avaliacao) {
        if (aluno != null && avaliacao != null) {
            instrutor.realizarAvaliacao(aluno, avaliacao);
            System.out.println("Avaliação registrada com sucesso para o aluno " + aluno.getNome());
        } else {
            System.out.println("Erro: aluno ou avaliação inválida.");
        }
    }

    public void listarAlunos() {
        if (instrutor.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno associado ao instrutor " + instrutor.getNome());
        } else {
            System.out.println("Alunos do instrutor " + instrutor.getNome() + ":");
            for (Aluno aluno : instrutor.getAlunos()) {
                System.out.println("- " + aluno.getNome());
            }
        }
    }
}
