package scr.gym.model.usuario.luta;

import java.util.List;

import scr.gym.model.usuario.aluno.Aluno;

public class Luta {
    private String tipo;
    private String horario;
    private String duracao;
    private String local;
    private String instrutor;
    private List<Aluno> aluno;

    public Luta(String tipo, String horario, String duracao, String local, String instrutor, List<Aluno> aluno) {
        this.tipo = tipo;
        this.horario = horario;
        this.duracao = duracao;
        this.local = local;
        this.instrutor = instrutor;
        this.aluno = aluno;
    }
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
    public void adicionarAluno(Aluno aluno){
        this.aluno.add(aluno);
    }
    public void removerAluno(Aluno aluno){
        this.aluno.remove(aluno);
    }
    public void listarAlunos(){
        for(Aluno a : aluno){
            System.out.println(a.getNome());
        }
    }
    public void alterarHorario(String novoHorario) {
        this.horario = novoHorario;
    }
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
