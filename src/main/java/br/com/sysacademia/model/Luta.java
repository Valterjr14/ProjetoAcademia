package br.com.sysacademia.model;

import java.util.List;

//Entidade que representa uma luta
public class Luta {

    //Atributos da luta
    private String tipo;
    private String horario;
    private String duracao;
    private String local;
    private String instrutor;
    private List<Aluno> aluno;

    //Construtor
    public Luta(String tipo, String horario, String duracao, String local, String instrutor, List<Aluno> aluno) {
        this.tipo = tipo;
        this.horario = horario;
        this.duracao = duracao;
        this.local = local;
        this.instrutor = instrutor;
        this.aluno = aluno;
    }

    //Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public String getHorario() {
        return horario;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getLocal() {
        return local;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aluno> getAlunos() {
        return aluno;
    }

    //Métodos para adicionar alunos
    public void adicionarAluno(Aluno aluno){
        this.aluno.add(aluno);
    }

    //Métodos para remover alunos
    public void removerAluno(Aluno aluno){
        this.aluno.remove(aluno);
    }

    //Métodos para listar alunos
    public void listarAlunos(){
        //Lista os alunos participantes da luta
        for(Aluno a : aluno){
            System.out.println(a.getNome());
        }
    }

    //Métodos para alterar horário
    public void alterarHorario(String novoHorario) {
        this.horario = novoHorario;
    }

    //Método toString
    @Override
    public String toString() {
        return "Luta{" +
                "tipo='" + tipo + '\'' +
                ", horario='" + horario + '\'' +
                ", duracao='" + duracao + '\'' +
                ", local='" + local + '\'' +
                ", instrutor='" + instrutor + '\'' +
                ", alunos=" + aluno +
                '}';
    }

}
